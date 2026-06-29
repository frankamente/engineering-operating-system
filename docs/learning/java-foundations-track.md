# Java Foundations Learning Track

## Status

Started.

## Purpose

This track starts the practical learning phase of the Engineering Operating System.

The goal is to learn Java deliberately at an intermediate backend-engineering level: understand the runtime and tooling, practice modern language features, use tests, document design choices, and reflect after each learning step.

This is not a beginner Java track. Avoid spending full learning units on trivial syntax or `Hello World`-style exercises.

## Learning Loop

Each learning unit should follow this loop:

1. Define the topic.
2. Write a concise knowledge note.
3. Complete a small practice task.
4. Record a journal entry.
5. Decide the next topic.

The point is not to collect notes. The point is to make learning compound.

## Current Module

### Module 1 - Java Toolchain and First Learning Slice

Focus:

- Java runtime and compiler versions.
- Maven runtime alignment.
- Package structure.
- Maven build lifecycle.
- A small domain-oriented exercise.
- Automated tests.

Learning outcomes:

- Explain the relevant JVM/JDK/JRE model without dwelling on basics.
- Identify whether `java`, `javac`, and Maven are using the same Java version.
- Create a small Maven-based Java learning slice.
- Write tests for the slice.
- Document trade-offs before introducing frameworks.

## Planned Modules

1. Java Toolchain and First Learning Slice.
2. Modern Java Language Essentials.
3. Object Modeling, Packages, and Boundaries.
4. Collections, Streams, and Error Handling.
5. Testing and Refactoring.
6. Build Tooling and Dependency Management.
7. First Backend-Oriented CLI or Library Exercise.

## Not Yet

Do not start these topics until the foundations are clearer:

- Spring.
- Kafka.
- Persistence.
- Web APIs.
- Cloud deployment.
- Microservices.

## Current Practice Prompt

Before writing the first learning slice, answer these questions:

- Which Java version do `java` and `javac` use?
- Which Java version does Maven use?
- Should the first learning slice align Maven to Java 25 or target the Java version Maven currently uses?
- What small domain problem is useful enough to test, but small enough to finish in one PR?

Then run:

```bash
java --version
javac --version
mvn -v
```

Record the toolchain state and decision in the learning journal.
