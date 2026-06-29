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

## Toolchain Decision

The slice targets Java 17 with Maven.

Reason:

- Maven is installed and runs on Java 17.
- The slice does not need Java 25-specific features.
- The mismatch between Java 25 CLI tools and Maven's Java 17 runtime should be handled explicitly later.

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

The slice remains Java 17-compatible because Maven still runs on Java 17 locally, and Java 17 is enough for these features.

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

Either:

- align Maven to Java 25 before practicing Java 25-specific features; or
- continue Java 17-compatible practice with object modeling, package boundaries, collections, streams, and error handling.
