package dev.frankamente.eos.learning.essentials;

import java.util.Objects;
import java.util.Set;

public sealed interface PracticeSignal
    permits PracticeSignal.Ready,
        PracticeSignal.Blocked,
        PracticeSignal.Completed,
        PracticeSignal.TooLarge {

  PracticeItem item();

  String summary();

  record Ready(PracticeItem item, Set<LanguageFeature> focus) implements PracticeSignal {

    public Ready {
      item = Objects.requireNonNull(item, "item must not be null");
      focus = Set.copyOf(Objects.requireNonNull(focus, "focus must not be null"));
      if (focus.isEmpty()) {
        throw new IllegalArgumentException("focus must not be empty");
      }
    }

    @Override
    public String summary() {
      return "Ready to practice " + item.title();
    }
  }

  record Blocked(PracticeItem item, String reason) implements PracticeSignal {

    public Blocked {
      item = Objects.requireNonNull(item, "item must not be null");
      reason = normalizeReason(reason);
    }

    @Override
    public String summary() {
      return "Blocked: " + reason;
    }
  }

  record Completed(PracticeItem item) implements PracticeSignal {

    public Completed {
      item = Objects.requireNonNull(item, "item must not be null");
    }

    @Override
    public String summary() {
      return "Completed " + item.title();
    }
  }

  record TooLarge(PracticeItem item, int maxMinutes) implements PracticeSignal {

    public TooLarge {
      item = Objects.requireNonNull(item, "item must not be null");
      if (maxMinutes <= 0) {
        throw new IllegalArgumentException("maxMinutes must be greater than zero");
      }
    }

    @Override
    public String summary() {
      return "Split " + item.title() + " before practicing";
    }
  }

  private static String normalizeReason(String reason) {
    Objects.requireNonNull(reason, "reason must not be null");
    var normalized = reason.trim();
    if (normalized.isEmpty()) {
      throw new IllegalArgumentException("reason must not be blank");
    }
    return normalized;
  }
}
