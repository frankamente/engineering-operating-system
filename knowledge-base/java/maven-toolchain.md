# Maven Toolchain Notes

## Status

Initial note.

## Local State

On 2026-06-29, the local workspace initially reported:

- `java`: OpenJDK 25.
- `javac`: 25.
- `mvn`: Apache Maven 3.9.11 running on Java 17.0.2.

That meant Maven was available, but its runtime JVM was not aligned with the Java version exposed by the default `java` and `javac` commands.

The local toolchain was then aligned. The workspace now reports:

- `java`: OpenJDK 25.
- `javac`: 25.
- `mvn`: Apache Maven 3.9.11 running on Java 25.

## Current Decision

The Maven learning slices target Java 25.

Reason:

- the local Java runtime is Java 25;
- the local Java compiler is Java 25;
- Maven now runs on Java 25;
- the Maven compiler release is Java 25;
- GitHub Actions uses Java 25 for Java learning slice tests.

## Implication

New Maven learning slices can use Java 25 as the baseline.

Existing slices do not need to use Java 25-specific language features just because the baseline changed. They should continue to use language features only when those features make the model clearer.

## Current Warning

Running Maven 3.9.11 on Java 25 may print a warning about `sun.misc.Unsafe` from Maven's Guice dependency.

This warning does not currently fail the build. Treat it as a toolchain compatibility warning to watch, not as a project test failure.

## Follow-Up

Before introducing advanced Java 25-specific language features, decide whether the feature is useful for the learning goal.

Do not add syntax demonstrations that have no modeling or testing value.
