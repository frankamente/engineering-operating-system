package dev.frankamente.eos.learning.workflow;

import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public final class WorkflowTransitionPolicy {

  private static final Map<WorkflowStatus, Set<WorkflowStatus>> DEFAULT_TRANSITIONS =
      Map.copyOf(defaultTransitions());

  public boolean canTransition(WorkItem item, WorkflowStatus targetStatus) {
    Objects.requireNonNull(item, "item must not be null");
    Objects.requireNonNull(targetStatus, "targetStatus must not be null");
    return allowedTargets(item.status()).contains(targetStatus);
  }

  public WorkItem transition(WorkItem item, WorkflowStatus targetStatus) {
    if (!canTransition(item, targetStatus)) {
      throw new IllegalStateException(
          "Cannot transition from " + item.status() + " to " + targetStatus);
    }

    return new WorkItem(item.id(), item.title(), targetStatus);
  }

  public Set<WorkflowStatus> allowedTargets(WorkflowStatus status) {
    Objects.requireNonNull(status, "status must not be null");
    return DEFAULT_TRANSITIONS.getOrDefault(status, Set.of());
  }

  private static Map<WorkflowStatus, Set<WorkflowStatus>> defaultTransitions() {
    var transitions = new EnumMap<WorkflowStatus, Set<WorkflowStatus>>(WorkflowStatus.class);
    transitions.put(WorkflowStatus.INBOX, statuses(WorkflowStatus.BACKLOG, WorkflowStatus.READY));
    transitions.put(WorkflowStatus.BACKLOG, statuses(WorkflowStatus.READY, WorkflowStatus.BLOCKED));
    transitions.put(WorkflowStatus.READY, statuses(WorkflowStatus.IN_PROGRESS, WorkflowStatus.BLOCKED));
    transitions.put(WorkflowStatus.IN_PROGRESS, statuses(WorkflowStatus.REVIEW, WorkflowStatus.BLOCKED));
    transitions.put(
        WorkflowStatus.REVIEW,
        statuses(WorkflowStatus.IN_PROGRESS, WorkflowStatus.DONE, WorkflowStatus.BLOCKED));
    transitions.put(WorkflowStatus.BLOCKED, statuses(WorkflowStatus.READY, WorkflowStatus.IN_PROGRESS));
    transitions.put(WorkflowStatus.DONE, statuses(WorkflowStatus.KNOWLEDGE));
    transitions.put(WorkflowStatus.KNOWLEDGE, Set.of());
    return transitions;
  }

  private static Set<WorkflowStatus> statuses(WorkflowStatus first, WorkflowStatus... rest) {
    return Collections.unmodifiableSet(EnumSet.of(first, rest));
  }
}
