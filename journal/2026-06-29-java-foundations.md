# Java Foundations Kickoff

## Date

2026-06-29

## Intent

Start learning Java through a deliberate loop:

```text
topic -> note -> practice -> reflection -> next topic
```

## Starting Point

The repository now has enough operating foundation to begin learning without waiting for every process document to be complete.

The first topic is the Java runtime model:

- JVM.
- JDK.
- JRE.
- Source code.
- Bytecode.
- Compile vs run.

## Practice Plan

1. Read `knowledge-base/java/jvm-jdk-jre.md`.
2. Run `java --version`.
3. Run `javac --version`.
4. Write down the installed Java version.
5. Explain the compile/run flow in your own words.

## Local Toolchain Check

`java --version`:

```text
openjdk 25 2025-09-16
OpenJDK Runtime Environment (build 25+36-3489)
OpenJDK 64-Bit Server VM (build 25+36-3489, mixed mode, sharing)
```

`javac --version`:

```text
javac 25
```

`mvn -v`:

```text
Apache Maven 3.9.11
Java version: 17.0.2
```

## First Understanding

The local machine has both the Java runtime command (`java`) and the Java compiler (`javac`) available.

Maven is also available, but it is currently running with Java 17 while `java` and `javac` report Java 25.

That mismatch should be handled deliberately before the first Maven-based learning slice.

## Level Calibration

The learning track should not spend time on beginner-level Java exercises.

The next useful step is an intermediate learning slice:

- Maven project structure.
- Package boundaries.
- Small domain model.
- Tests.
- Toolchain decision.

## Reflection Prompts

- What did I understand clearly?
- What still feels fuzzy?
- What did I assume before checking?
- What should be practiced next?

## Next Learning Step

Create a small Maven-based Java learning slice and document the Java 25 vs Maven Java 17 toolchain decision.

## Maven Learning Slice

Created the first Maven-based learning slice under:

```text
learning/java/toolchain-slice
```

The slice models workflow items and WIP limits:

- `WorkflowStatus`
- `WorkItem`
- `WipLimitPolicy`
- `WorkflowTransitionPolicy`

The exercise is intentionally small but not trivial. After recalibrating the target level, it includes explicit workflow transition rules so the code has a more realistic modeling decision without jumping to frameworks or product application code.

It practices:

- Maven project layout.
- Java package structure.
- Records and enums.
- Validation.
- Collections.
- Immutable transitions.
- JUnit tests.

## Initial Toolchain Decision

The slice initially targeted Java 17 with Maven.

Reason:

- Maven is installed and runs on Java 17.
- The slice does not need Java 25-specific features.
- The mismatch between Java 25 CLI tools and Maven's Java 17 runtime should be handled explicitly later.

This decision was later superseded after Maven was aligned to Java 25.

## Test Result

Command:

```bash
mvn test
```

Result:

```text
Tests run: 16, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

The first Maven slice is working locally.

## Next Learning Step After This Slice

Either:

- align Maven to Java 25 before using newer language features; or
- continue one more Java 17-compatible slice focused on modern Java essentials.

## Modern Java Language Essentials Slice

Created the second Maven-based learning slice under:

```text
learning/java/language-essentials-slice
```

The slice models a compact practice planner:

- `PracticeItem`
- `PracticeStatus`
- `LanguageFeature`
- `PracticeSignal`
- `PracticePlanner`

The goal is to practice modern Java features in code that has domain behavior, not just syntax examples.

It practices:

- records with compact constructors;
- defensive copies for immutable boundaries;
- sealed interfaces for finite result shapes;
- switch expressions;
- streams for filtering, sorting, grouping, flattening, and frequency counts;
- Optional lookup behavior;
- explicit validation and error handling;
- JUnit behavior tests.

The slice was originally Java 17-compatible because Maven still ran on Java 17 locally. After toolchain alignment, it targets Java 25 with the rest of the Maven learning baseline.

## Modern Java Essentials Test Result

Command:

```bash
mvn test
```

Result:

```text
Tests run: 28, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

The second Maven slice is working locally.

## Next Learning Step After Modern Java Essentials

- Continue Java practice with object modeling, package boundaries, collections, streams, and error handling.
- Use Java 25-specific features only when they add modeling or testing value.

## Java 25 Maven Alignment

Maven was aligned to Java 25 after the first two Maven learning slices.

Current local toolchain:

```text
java: OpenJDK 25
javac: 25
mvn: Apache Maven 3.9.11 running on Java 25
```

The existing Maven learning slices now use:

```text
maven.compiler.release=25
```

GitHub Actions also uses Java 25 for Java learning slice tests.

Local validation after alignment:

```text
toolchain-slice: 16 tests, 0 failures
language-essentials-slice: 28 tests, 0 failures
```

Maven 3.9.11 currently prints a Java 25 warning about `sun.misc.Unsafe` from its Guice dependency. The warning does not fail the build.
