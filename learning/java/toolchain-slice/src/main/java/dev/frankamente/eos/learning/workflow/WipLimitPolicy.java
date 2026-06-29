package dev.frankamente.eos.learning.workflow;

import java.util.Collection;
import java.util.Objects;

public record WipLimitPolicy(int maxActiveItems) {

  public WipLimitPolicy {
    if (maxActiveItems <= 0) {
      throw new IllegalArgumentException("maxActiveItems must be greater than zero");
    }
  }

  public boolean canStartMoreWork(Collection<WorkItem> items) {
    Objects.requireNonNull(items, "items must not be null");
    return activeItemCount(items) < maxActiveItems;
  }

  public long activeItemCount(Collection<WorkItem> items) {
    Objects.requireNonNull(items, "items must not be null");
    return items.stream()
        .filter(Objects::nonNull)
        .filter(WorkItem::countsTowardWip)
        .count();
  }
}
