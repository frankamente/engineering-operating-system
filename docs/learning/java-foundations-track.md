# Java Foundations Learning Track

## Status

Started.

## Purpose

This track starts the practical learning phase of the Engineering Operating System.

The goal is to learn Java deliberately: understand the runtime, practice the language, document the mental model, and reflect after each learning step.

## Learning Loop

Each learning unit should follow this loop:

1. Define the topic.
2. Write a concise knowledge note.
3. Complete a small practice task.
4. Record a journal entry.
5. Decide the next topic.

The point is not to collect notes. The point is to make learning compound.

## Current Module

### Module 1 - Java Runtime and Tooling

Focus:

- JVM.
- JDK.
- JRE.
- Source files and bytecode.
- `javac` and `java`.
- Minimal project structure.

Learning outcomes:

- Explain the difference between JDK, JRE, and JVM.
- Describe what happens when a `.java` file becomes a running program.
- Run the basic Java toolchain commands locally.
- Identify what should and should not be learned before Maven, Gradle, or Spring.

## Planned Modules

1. Java Runtime and Tooling.
2. Types, Variables, and Control Flow.
3. Classes, Objects, and Packages.
4. Collections and Error Handling.
5. First Java CLI Exercise.
6. Testing Basics.
7. Build Tools Introduction.

## Not Yet

Do not start these topics until the foundations are clearer:

- Spring.
- Kafka.
- Persistence.
- Web APIs.
- Cloud deployment.
- Microservices.

## Current Practice Prompt

Before writing application code, answer these questions in your own words:

- What does the JDK contain?
- What does the JVM execute?
- Why can Java bytecode run on different operating systems?
- What is the difference between compiling and running?

Then run:

```bash
java --version
javac --version
```

Record what is installed locally in the learning journal.
