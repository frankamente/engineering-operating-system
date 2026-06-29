package dev.frankamente.eos.learning.essentials;

import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class PracticePlanner {

  private final int maxRecommendedMinutes;

  public PracticePlanner(int maxRecommendedMinutes) {
    if (maxRecommendedMinutes <= 0) {
      throw new IllegalArgumentException("maxRecommendedMinutes must be greater than zero");
    }
    this.maxRecommendedMinutes = maxRecommendedMinutes;
  }

  public List<PracticeItem> recommend(Collection<PracticeItem> items) {
    return nonNullItems(items)
        .filter(PracticeItem::isActionable)
        .filter(item -> item.estimatedMinutes() <= maxRecommendedMinutes)
        .sorted(recommendationOrder())
        .toList();
  }

  public Optional<PracticeItem> findById(Collection<PracticeItem> items, String id) {
    var normalizedId = normalizeId(id);
    return nonNullItems(items)
        .filter(item -> item.id().equals(normalizedId))
        .findFirst();
  }

  public Map<PracticeStatus, Long> countByStatus(Collection<PracticeItem> items) {
    return nonNullItems(items)
        .collect(Collectors.groupingBy(
            PracticeItem::status,
            () -> new EnumMap<>(PracticeStatus.class),
            Collectors.counting()));
  }

  public Set<LanguageFeature> coveredFeatures(Collection<PracticeItem> items) {
    return nonNullItems(items)
        .flatMap(item -> item.features().stream())
        .collect(Collectors.toUnmodifiableSet());
  }

  public Map<LanguageFeature, Long> featureFrequency(Collection<PracticeItem> items) {
    return nonNullItems(items)
        .flatMap(item -> item.features().stream())
        .collect(Collectors.groupingBy(
            Function.identity(),
            () -> new EnumMap<>(LanguageFeature.class),
            Collectors.counting()));
  }

  public PracticeSignal evaluate(PracticeItem item) {
    Objects.requireNonNull(item, "item must not be null");
    return switch (item.status()) {
      case TODO -> new PracticeSignal.Blocked(item, "item is not ready yet");
      case BLOCKED -> new PracticeSignal.Blocked(item, "item is blocked");
      case DONE -> new PracticeSignal.Completed(item);
      case READY, IN_PROGRESS -> item.estimatedMinutes() > maxRecommendedMinutes
          ? new PracticeSignal.TooLarge(item, maxRecommendedMinutes)
          : new PracticeSignal.Ready(item, item.features());
    };
  }

  public List<PracticeSignal> evaluateAll(Collection<PracticeItem> items) {
    return nonNullItems(items)
        .map(this::evaluate)
        .toList();
  }

  private static Comparator<PracticeItem> recommendationOrder() {
    return Comparator
        .comparingInt((PracticeItem item) -> statusRank(item.status()))
        .thenComparingInt(PracticeItem::estimatedMinutes)
        .thenComparing(PracticeItem::id);
  }

  private static int statusRank(PracticeStatus status) {
    return switch (status) {
      case IN_PROGRESS -> 0;
      case READY -> 1;
      case TODO -> 2;
      case BLOCKED -> 3;
      case DONE -> 4;
    };
  }

  private static Stream<PracticeItem> nonNullItems(Collection<PracticeItem> items) {
    Objects.requireNonNull(items, "items must not be null");
    return items.stream().filter(Objects::nonNull);
  }

  private static String normalizeId(String id) {
    Objects.requireNonNull(id, "id must not be null");
    var normalized = id.trim();
    if (normalized.isEmpty()) {
      throw new IllegalArgumentException("id must not be blank");
    }
    return normalized;
  }
}
