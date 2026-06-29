package dev.frankamente.eos.learning.essentials;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EnumSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class PracticeSignalTest {

  @Test
  void readySignalCopiesFocusDefensively() {
    var focus = EnumSet.of(LanguageFeature.RECORDS);
    var signal = new PracticeSignal.Ready(item(), focus);

    focus.add(LanguageFeature.STREAMS);

    assertEquals(Set.of(LanguageFeature.RECORDS), signal.focus());
    assertThrows(UnsupportedOperationException.class, () -> signal.focus().add(LanguageFeature.JUNIT));
  }

  @Test
  void readySignalRequiresFocus() {
    assertThrows(IllegalArgumentException.class, () -> new PracticeSignal.Ready(item(), Set.of()));
  }

  @Test
  void blockedSignalNormalizesReason() {
    var signal = new PracticeSignal.Blocked(item(), " missing context ");

    assertEquals("missing context", signal.reason());
    assertEquals("Blocked: missing context", signal.summary());
  }

  @Test
  void blockedSignalRejectsBlankReason() {
    assertThrows(IllegalArgumentException.class, () -> new PracticeSignal.Blocked(item(), " "));
  }

  @Test
  void tooLargeSignalRequiresPositiveLimit() {
    assertThrows(IllegalArgumentException.class, () -> new PracticeSignal.TooLarge(item(), 0));
  }

  @Test
  void completedSignalSummarizesItem() {
    var signal = new PracticeSignal.Completed(item());

    assertEquals("Completed Practice EOS-8", signal.summary());
  }

  private static PracticeItem item() {
    return new PracticeItem(
        "EOS-8",
        "Practice EOS-8",
        PracticeStatus.READY,
        45,
        Set.of(LanguageFeature.RECORDS));
  }
}
