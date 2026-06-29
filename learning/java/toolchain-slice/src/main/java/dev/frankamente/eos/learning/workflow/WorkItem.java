package dev.frankamente.eos.learning.workflow;

import java.util.Objects;

public record WorkItem(String id, String title, WorkflowStatus status) {

  public WorkItem {
    id = normalize("id", id);
    title = normalize("title", title);
    status = Objects.requireNonNull(status, "status must not be null");
  }

  public boolean countsTowardWip() {
    return status == WorkflowStatus.IN_PROGRESS || status == WorkflowStatus.REVIEW;
  }

  private static String normalize(String fieldName, String value) {
    Objects.requireNonNull(value, fieldName + " must not be null");
    var normalized = value.trim();
    if (normalized.isEmpty()) {
      throw new IllegalArgumentException(fieldName + " must not be blank");
    }
    return normalized;
  }
}
