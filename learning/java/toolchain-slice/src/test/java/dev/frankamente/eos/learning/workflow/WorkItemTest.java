package dev.frankamente.eos.learning.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class WorkItemTest {

  @Test
  void trimsIdentifierAndTitle() {
    var item = new WorkItem(" EOS-7 ", " Build first Java slice ", WorkflowStatus.READY);

    assertEquals("EOS-7", item.id());
    assertEquals("Build first Java slice", item.title());
  }

  @Test
  void rejectsBlankIdentifier() {
    assertThrows(
        IllegalArgumentException.class,
        () -> new WorkItem("  ", "Build first Java slice", WorkflowStatus.READY));
  }

  @Test
  void rejectsBlankTitle() {
    assertThrows(
        IllegalArgumentException.class,
        () -> new WorkItem("EOS-7", "  ", WorkflowStatus.READY));
  }

  @Test
  void requiresStatus() {
    assertThrows(
        NullPointerException.class,
        () -> new WorkItem("EOS-7", "Build first Java slice", null));
  }

  @Test
  void onlyInProgressAndReviewCountTowardWip() {
    assertFalse(new WorkItem("EOS-1", "Ready work", WorkflowStatus.READY).countsTowardWip());
    assertTrue(new WorkItem("EOS-2", "Active work", WorkflowStatus.IN_PROGRESS).countsTowardWip());
    assertTrue(new WorkItem("EOS-3", "Review work", WorkflowStatus.REVIEW).countsTowardWip());
    assertFalse(new WorkItem("EOS-4", "Done work", WorkflowStatus.DONE).countsTowardWip());
  }
}
