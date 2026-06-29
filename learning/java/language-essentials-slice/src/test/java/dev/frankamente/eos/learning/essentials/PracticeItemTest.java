package dev.frankamente.eos.learning.essentials;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EnumSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class PracticeItemTest {

  @Test
  void trimsIdentifierAndTitle() {
    var item = item(" EOS-8 ", " Modern Java essentials ", PracticeStatus.READY, 45);

    assertEquals("EOS-8", item.id());
    assertEquals("Modern Java essentials", item.title());
  }

  @Test
  void rejectsInvalidTextFields() {
    assertThrows(IllegalArgumentException.class, () -> item(" ", "Modern Java", PracticeStatus.READY, 45));
    assertThrows(IllegalArgumentException.class, () -> item("EOS-8", " ", PracticeStatus.READY, 45));
  }

  @Test
  void rejectsMissingStatusAndInvalidEstimate() {
    assertThrows(NullPointerException.class, () -> item("EOS-8", "Modern Java", null, 45));
    assertThrows(IllegalArgumentException.class, () -> item("EOS-8", "Modern Java", PracticeStatus.READY, 0));
  }

  @Test
  void requiresAtLeastOneLanguageFeature() {
    assertThrows(
        IllegalArgumentException.class,
        () -> new PracticeItem("EOS-8", "Modern Java", PracticeStatus.READY, 45, Set.of()));
  }

  @Test
  void copiesFeaturesDefensively() {
    var features = EnumSet.of(LanguageFeature.RECORDS, LanguageFeature.STREAMS);
    var item = new PracticeItem("EOS-8", "Modern Java", PracticeStatus.READY, 45, features);

    features.add(LanguageFeature.JUNIT);

    assertEquals(Set.of(LanguageFeature.RECORDS, LanguageFeature.STREAMS), item.features());
    assertThrows(UnsupportedOperationException.class, () -> item.features().add(LanguageFeature.JUNIT));
  }

  @Test
  void onlyReadyAndInProgressItemsAreActionable() {
    assertFalse(item("EOS-1", "Todo", PracticeStatus.TODO, 15).isActionable());
    assertTrue(item("EOS-2", "Ready", PracticeStatus.READY, 15).isActionable());
    assertTrue(item("EOS-3", "In progress", PracticeStatus.IN_PROGRESS, 15).isActionable());
    assertFalse(item("EOS-4", "Done", PracticeStatus.DONE, 15).isActionable());
    assertFalse(item("EOS-5", "Blocked", PracticeStatus.BLOCKED, 15).isActionable());
  }

  @Test
  void createsNewItemWhenChangingStatus() {
    var item = item("EOS-8", "Modern Java", PracticeStatus.READY, 45);

    var updated = item.withStatus(PracticeStatus.IN_PROGRESS);

    assertNotSame(item, updated);
    assertEquals(PracticeStatus.READY, item.status());
    assertEquals(PracticeStatus.IN_PROGRESS, updated.status());
    assertEquals(item.features(), updated.features());
  }

  private static PracticeItem item(
      String id,
      String title,
      PracticeStatus status,
      int estimatedMinutes) {
    return new PracticeItem(
        id,
        title,
        status,
        estimatedMinutes,
        Set.of(LanguageFeature.RECORDS, LanguageFeature.STREAMS));
  }
}
