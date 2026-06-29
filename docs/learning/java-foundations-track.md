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

## Modules

### Module 1 - Java Toolchain and First Learning Slice

Status: complete.

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
- Model explicit workflow rules without introducing framework code.

Current slice:

- `learning/java/toolchain-slice`

The first slice includes WIP limit behavior and workflow transition rules. This keeps the exercise compact while making it more useful than introductory syntax practice.

### Module 2 - Modern Java Language Essentials

Status: complete.

Focus:

- Records with validation and defensive copies.
- Sealed result types.
- Switch expressions.
- Streams for filtering, sorting, grouping, and flattening.
- Optional for lookup behavior.
- Explicit, test-backed error handling.

Learning outcomes:

- Model finite result shapes with sealed interfaces.
- Use modern Java features when they clarify the domain.
- Keep immutable data and collection boundaries explicit.
- Test behavior rather than syntax trivia.

Current slice:

- `learning/java/language-essentials-slice`

The second slice models a compact practice planner. It stays framework-free and Java 17-compatible while practicing modern Java features in a domain that belongs to this repository.

## Planned Modules

1. Object Modeling, Packages, and Boundaries.
2. Collections, Streams, and Error Handling.
3. Testing and Refactoring.
4. Build Tooling and Dependency Management.
5. First Backend-Oriented CLI or Library Exercise.

## Not Yet

Do not start these topics until the foundations are clearer:

- Spring.
- Kafka.
- Persistence.
- Web APIs.
- Cloud deployment.
- Microservices.

## Practice Prompt History

### Java Toolchain and First Maven Slice

Before writing the first Maven learning slice, answer these questions:

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

### Modern Java Language Essentials

Create a second Maven learning slice that practices:

- records;
- sealed interfaces;
- switch expressions;
- streams;
- Optional;
- immutable collections;
- result-style error handling.

Keep the exercise Java 17-compatible unless Maven toolchain alignment is handled first.

## Current Toolchain Decision

The Maven learning slices target Java 17 because Maven currently runs on Java 17.

This avoids hiding a toolchain alignment problem inside the learning exercise. Java 25 remains available locally through `java` and `javac`, but Java 25-specific language features should wait until Maven alignment is handled deliberately.

## Next Practice Prompt

Continue with object modeling, package boundaries, collections, streams, and error handling, or decide first whether Maven should be aligned to Java 25 before using Java 25-specific language features.
