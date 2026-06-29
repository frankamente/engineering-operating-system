package dev.frankamente.eos.learning.essentials;

import java.util.Objects;
import java.util.Set;

public record PracticeItem(
    String id,
    String title,
    PracticeStatus status,
    int estimatedMinutes,
    Set<LanguageFeature> features) {

  public PracticeItem {
    id = normalize("id", id);
    title = normalize("title", title);
    status = Objects.requireNonNull(status, "status must not be null");
    if (estimatedMinutes <= 0) {
      throw new IllegalArgumentException("estimatedMinutes must be greater than zero");
    }
    features = Set.copyOf(Objects.requireNonNull(features, "features must not be null"));
    if (features.isEmpty()) {
      throw new IllegalArgumentException("features must not be empty");
    }
  }

  public boolean isActionable() {
    return status == PracticeStatus.READY || status == PracticeStatus.IN_PROGRESS;
  }

  public PracticeItem withStatus(PracticeStatus newStatus) {
    return new PracticeItem(id, title, newStatus, estimatedMinutes, features);
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
