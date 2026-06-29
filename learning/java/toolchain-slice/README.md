# Java Toolchain Slice

## Purpose

This learning slice practices professional Java basics without introducing product application code.

It uses a tiny domain from this repository: workflow items and WIP limits.

## Toolchain Decision

The local machine currently reports:

- `java`: OpenJDK 25.
- `javac`: 25.
- `mvn`: Maven 3.9.11 running on Java 25.

For this slice, the Maven project targets Java 25 with `maven.compiler.release=25`.

Reason: the command-line JDK, compiler, Maven runtime, Maven compiler release, and CI baseline are now aligned on Java 25.

## Domain

The slice models:

- `WorkflowStatus`: the states a work item can have.
- `WorkItem`: a small immutable item with validation.
- `WipLimitPolicy`: a policy that decides whether more work can enter active flow.
- `WorkflowTransitionPolicy`: a policy that decides which workflow state changes are valid.

The exercise is intentionally small, but it is not a `Hello World`.

## Run

From this directory:

```bash
mvn test
```

## Learning Goals

- Read and reason about a Maven `pom.xml`.
- Understand source and test package structure.
- Practice Java records, enums, validation, and collections.
- Practice immutable transition behavior and explicit domain rules.
- Use JUnit tests to express expected behavior.
- Document a toolchain trade-off explicitly.
