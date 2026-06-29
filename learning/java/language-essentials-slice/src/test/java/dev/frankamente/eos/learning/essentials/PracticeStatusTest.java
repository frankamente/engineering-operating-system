package dev.frankamente.eos.learning.essentials;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PracticeStatusTest {

  @Test
  void identifiesOpenStatuses() {
    assertTrue(PracticeStatus.TODO.isOpen());
    assertTrue(PracticeStatus.READY.isOpen());
    assertTrue(PracticeStatus.IN_PROGRESS.isOpen());
    assertFalse(PracticeStatus.DONE.isOpen());
    assertFalse(PracticeStatus.BLOCKED.isOpen());
  }

  @Test
  void describesNextActionForEachStatus() {
    assertEquals("prepare", PracticeStatus.TODO.nextAction());
    assertEquals("start", PracticeStatus.READY.nextAction());
    assertEquals("finish", PracticeStatus.IN_PROGRESS.nextAction());
    assertEquals("reflect", PracticeStatus.DONE.nextAction());
    assertEquals("unblock", PracticeStatus.BLOCKED.nextAction());
  }
}
