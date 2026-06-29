package dev.frankamente.eos.learning.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class WipLimitPolicyTest {

  @Test
  void rejectsInvalidLimit() {
    assertThrows(IllegalArgumentException.class, () -> new WipLimitPolicy(0));
  }

  @Test
  void countsOnlyActiveWorkflowItems() {
    var policy = new WipLimitPolicy(3);
    var items = List.of(
        new WorkItem("EOS-1", "Ready", WorkflowStatus.READY),
        new WorkItem("EOS-2", "Implementation", WorkflowStatus.IN_PROGRESS),
        new WorkItem("EOS-3", "Review", WorkflowStatus.REVIEW),
        new WorkItem("EOS-4", "Done", WorkflowStatus.DONE));

    assertEquals(2, policy.activeItemCount(items));
  }

  @Test
  void allowsMoreWorkWhenBelowLimit() {
    var policy = new WipLimitPolicy(2);
    var items = List.of(
        new WorkItem("EOS-1", "Implementation", WorkflowStatus.IN_PROGRESS),
        new WorkItem("EOS-2", "Ready", WorkflowStatus.READY));

    assertTrue(policy.canStartMoreWork(items));
  }

  @Test
  void blocksMoreWorkWhenLimitIsReached() {
    var policy = new WipLimitPolicy(2);
    var items = List.of(
        new WorkItem("EOS-1", "Implementation", WorkflowStatus.IN_PROGRESS),
        new WorkItem("EOS-2", "Review", WorkflowStatus.REVIEW));

    assertFalse(policy.canStartMoreWork(items));
  }

  @Test
  void ignoresNullItemsWhenCountingActiveWork() {
    var policy = new WipLimitPolicy(1);
    var items = java.util.Arrays.asList(
        null,
        new WorkItem("EOS-1", "Implementation", WorkflowStatus.IN_PROGRESS));

    assertEquals(1, policy.activeItemCount(items));
  }
}
