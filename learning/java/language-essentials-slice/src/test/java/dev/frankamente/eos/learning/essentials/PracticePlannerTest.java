package dev.frankamente.eos.learning.essentials;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;

class PracticePlannerTest {

  private final PracticePlanner planner = new PracticePlanner(60);

  @Test
  void rejectsInvalidRecommendationLimit() {
    assertThrows(IllegalArgumentException.class, () -> new PracticePlanner(0));
  }

  @Test
  void recommendsActionableItemsWithinLimitInUsefulOrder() {
    var recommendations = planner.recommend(List.of(
        item("EOS-1", PracticeStatus.READY, 45, LanguageFeature.RECORDS),
        item("EOS-2", PracticeStatus.IN_PROGRESS, 50, LanguageFeature.STREAMS),
        item("EOS-3", PracticeStatus.READY, 120, LanguageFeature.SEALED_TYPES),
        item("EOS-4", PracticeStatus.DONE, 15, LanguageFeature.JUNIT),
        item("EOS-5", PracticeStatus.BLOCKED, 15, LanguageFeature.OPTIONAL),
        item("EOS-6", PracticeStatus.READY, 20, LanguageFeature.SWITCH_EXPRESSIONS)));

    assertEquals(
        List.of("EOS-2", "EOS-6", "EOS-1"),
        recommendations.stream().map(PracticeItem::id).toList());
  }

  @Test
  void findsItemsByTrimmedIdentifier() {
    var items = List.of(item("EOS-8", PracticeStatus.READY, 45, LanguageFeature.RECORDS));

    assertTrue(planner.findById(items, " EOS-8 ").isPresent());
    assertTrue(planner.findById(items, "EOS-999").isEmpty());
  }

  @Test
  void rejectsBlankLookupIdentifier() {
    assertThrows(IllegalArgumentException.class, () -> planner.findById(List.of(), " "));
  }

  @Test
  void countsItemsByStatusAndIgnoresNullItems() {
    var items = Arrays.asList(
        item("EOS-1", PracticeStatus.READY, 45, LanguageFeature.RECORDS),
        null,
        item("EOS-2", PracticeStatus.READY, 30, LanguageFeature.STREAMS),
        item("EOS-3", PracticeStatus.DONE, 30, LanguageFeature.JUNIT));

    assertEquals(
        Map.of(PracticeStatus.READY, 2L, PracticeStatus.DONE, 1L),
        planner.countByStatus(items));
  }

  @Test
  void returnsCoveredLanguageFeatures() {
    var features = planner.coveredFeatures(List.of(
        item("EOS-1", PracticeStatus.READY, 45, LanguageFeature.RECORDS, LanguageFeature.STREAMS),
        item("EOS-2", PracticeStatus.READY, 30, LanguageFeature.STREAMS, LanguageFeature.OPTIONAL)));

    assertEquals(Set.of(LanguageFeature.RECORDS, LanguageFeature.STREAMS, LanguageFeature.OPTIONAL), features);
    assertThrows(UnsupportedOperationException.class, () -> features.add(LanguageFeature.JUNIT));
  }

  @Test
  void countsLanguageFeatureFrequency() {
    var frequency = planner.featureFrequency(List.of(
        item("EOS-1", PracticeStatus.READY, 45, LanguageFeature.RECORDS, LanguageFeature.STREAMS),
        item("EOS-2", PracticeStatus.READY, 30, LanguageFeature.STREAMS, LanguageFeature.OPTIONAL)));

    assertEquals(1L, frequency.get(LanguageFeature.RECORDS));
    assertEquals(2L, frequency.get(LanguageFeature.STREAMS));
    assertEquals(1L, frequency.get(LanguageFeature.OPTIONAL));
  }

  @Test
  void evaluatesReadyItemAsReadySignal() {
    var signal = planner.evaluate(item("EOS-8", PracticeStatus.READY, 45, LanguageFeature.RECORDS));

    var ready = assertInstanceOf(PracticeSignal.Ready.class, signal);
    assertEquals(Set.of(LanguageFeature.RECORDS), ready.focus());
  }

  @Test
  void evaluatesOversizedActionableItemAsTooLargeSignal() {
    var signal = planner.evaluate(item("EOS-8", PracticeStatus.READY, 90, LanguageFeature.SEALED_TYPES));

    var tooLarge = assertInstanceOf(PracticeSignal.TooLarge.class, signal);
    assertEquals(60, tooLarge.maxMinutes());
  }

  @Test
  void evaluatesBlockedAndTodoItemsAsBlockedSignals() {
    assertInstanceOf(
        PracticeSignal.Blocked.class,
        planner.evaluate(item("EOS-1", PracticeStatus.BLOCKED, 30, LanguageFeature.OPTIONAL)));
    assertInstanceOf(
        PracticeSignal.Blocked.class,
        planner.evaluate(item("EOS-2", PracticeStatus.TODO, 30, LanguageFeature.RECORDS)));
  }

  @Test
  void evaluatesDoneItemAsCompletedSignal() {
    assertInstanceOf(
        PracticeSignal.Completed.class,
        planner.evaluate(item("EOS-8", PracticeStatus.DONE, 45, LanguageFeature.JUNIT)));
  }

  @Test
  void evaluatesAllItemsAndIgnoresNullItems() {
    var signals = planner.evaluateAll(Arrays.asList(
        item("EOS-1", PracticeStatus.READY, 45, LanguageFeature.RECORDS),
        null,
        item("EOS-2", PracticeStatus.DONE, 30, LanguageFeature.JUNIT)));

    assertEquals(2, signals.size());
    assertInstanceOf(PracticeSignal.Ready.class, signals.get(0));
    assertInstanceOf(PracticeSignal.Completed.class, signals.get(1));
  }

  @Test
  void requiresCollectionsAndItems() {
    assertThrows(NullPointerException.class, () -> planner.recommend(null));
    assertThrows(NullPointerException.class, () -> planner.countByStatus(null));
    assertThrows(NullPointerException.class, () -> planner.coveredFeatures(null));
    assertThrows(NullPointerException.class, () -> planner.featureFrequency(null));
    assertThrows(NullPointerException.class, () -> planner.evaluate(null));
  }

  private static PracticeItem item(
      String id,
      PracticeStatus status,
      int estimatedMinutes,
      LanguageFeature... features) {
    return new PracticeItem(
        id,
        "Practice " + id,
        status,
        estimatedMinutes,
        Set.of(features));
  }
}
