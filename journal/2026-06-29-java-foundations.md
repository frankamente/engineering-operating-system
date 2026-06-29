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

## First Understanding

The local machine has both the Java runtime command (`java`) and the Java compiler (`javac`) available.

That means the next practice step can use plain JDK tools without introducing an IDE, Maven, Gradle, or Spring yet.

## Reflection Prompts

- What did I understand clearly?
- What still feels fuzzy?
- What did I assume before checking?
- What should be practiced next?

## Next Learning Step

Create and run the smallest possible Java program using only the JDK tools.
