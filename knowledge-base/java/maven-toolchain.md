# Maven Toolchain Notes

## Status

Initial note.

## Local State

On 2026-06-29, the local workspace reported:

- `java`: OpenJDK 25.
- `javac`: 25.
- `mvn`: Apache Maven 3.9.11 running on Java 17.0.2.

This means Maven is available, but its runtime JVM is not aligned with the Java version exposed by the default `java` and `javac` commands.

## Decision for the First Slice

The first Maven learning slice targets Java 17.

Reason:

- Maven already runs on Java 17.
- The first slice does not need Java 25-specific language features.
- The goal is to practice Maven structure, packages, small domain modeling, and tests.
- Aligning Maven to Java 25 is a separate tooling task and should not be hidden inside the first learning exercise.

## Implication

The first slice can safely use Java language features available in Java 17, including records and modern switch expressions if needed.

It should avoid Java 25-specific features until the Maven runtime and compiler target are deliberately aligned.

## Follow-Up

Before introducing advanced Java 25 language features, decide whether to:

- align Maven to Java 25;
- keep Java 17 as the learning baseline for a while;
- use Maven toolchains to compile with a different JDK than Maven itself runs on.
