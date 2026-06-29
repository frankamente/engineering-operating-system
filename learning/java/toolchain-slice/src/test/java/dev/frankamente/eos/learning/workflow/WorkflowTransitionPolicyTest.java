package dev.frankamente.eos.learning.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;
import org.junit.jupiter.api.Test;

class WorkflowTransitionPolicyTest {

  private final WorkflowTransitionPolicy policy = new WorkflowTransitionPolicy();

  @Test
  void exposesAllowedTargetsForAStatus() {
    assertEquals(
        Set.of(WorkflowStatus.IN_PROGRESS, WorkflowStatus.DONE, WorkflowStatus.BLOCKED),
        policy.allowedTargets(WorkflowStatus.REVIEW));
  }

  @Test
  void preventsUnsupportedTransitions() {
    var item = new WorkItem("EOS-7", "Build first Java slice", WorkflowStatus.READY);

    assertFalse(policy.canTransition(item, WorkflowStatus.DONE));
    assertThrows(IllegalStateException.class, () -> policy.transition(item, WorkflowStatus.DONE));
  }

  @Test
  void createsANewItemWhenTransitionIsAllowed() {
    var item = new WorkItem("EOS-7", "Build first Java slice", WorkflowStatus.READY);

    var transitioned = policy.transition(item, WorkflowStatus.IN_PROGRESS);

    assertEquals("EOS-7", transitioned.id());
    assertEquals("Build first Java slice", transitioned.title());
    assertEquals(WorkflowStatus.IN_PROGRESS, transitioned.status());
    assertEquals(WorkflowStatus.READY, item.status());
  }

  @Test
  void allowsReviewFeedbackToReturnToImplementation() {
    var item = new WorkItem("EOS-7", "Build first Java slice", WorkflowStatus.REVIEW);

    assertTrue(policy.canTransition(item, WorkflowStatus.IN_PROGRESS));
  }

  @Test
  void returnsImmutableAllowedTargets() {
    var targets = policy.allowedTargets(WorkflowStatus.READY);

    assertThrows(UnsupportedOperationException.class, () -> targets.add(WorkflowStatus.DONE));
  }

  @Test
  void requiresTransitionInputs() {
    var item = new WorkItem("EOS-7", "Build first Java slice", WorkflowStatus.READY);

    assertThrows(NullPointerException.class, () -> policy.canTransition(null, WorkflowStatus.DONE));
    assertThrows(NullPointerException.class, () -> policy.canTransition(item, null));
    assertThrows(NullPointerException.class, () -> policy.allowedTargets(null));
  }
}
