# Java Language Essentials Slice

## Purpose

This learning slice practices modern Java language features in a compact domain.

It models a practice planner for Java learning items. The code is intentionally framework-free and product-free: the goal is language fluency, not application architecture.

## Toolchain Decision

This slice keeps the Java 17 Maven target used by the first Maven slice.

Reason: Java 17 already supports records, sealed types, switch expressions, streams, Optional, and immutable collection APIs. Using those well is more valuable right now than changing the toolchain just to reach Java 25-specific features.

## Domain

The slice models:

- `PracticeItem`: an immutable learning item with validation.
- `PracticeStatus`: workflow states for practice.
- `LanguageFeature`: the Java feature area practiced by an item.
- `PracticeSignal`: a sealed result type for planner evaluation.
- `PracticePlanner`: queries, grouping, recommendations, and result-style evaluation.

## Run

From this directory:

```bash
mvn test
```

## Learning Goals

- Practice records with compact constructors and defensive copies.
- Use sealed interfaces to model finite result shapes.
- Use switch expressions for explicit branching.
- Use streams for filtering, sorting, grouping, and set construction.
- Use Optional for lookup behavior.
- Keep error handling explicit and test-backed.
