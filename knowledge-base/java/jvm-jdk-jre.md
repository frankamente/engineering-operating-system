# JVM, JDK, and JRE

## Status

Initial note.

## Mental Model

Java is not only a language. It is a language plus a runtime model.

The basic flow is:

```text
Java source code (.java)
  -> compiled by javac
  -> Java bytecode (.class)
  -> executed by the JVM
```

This separation is one of the reasons Java can run across operating systems. The compiled bytecode targets the JVM, and each operating system has its own JVM implementation.

## JVM

The Java Virtual Machine executes Java bytecode.

It is responsible for running compiled Java programs and managing runtime concerns such as memory, class loading, and execution.

The JVM does not execute `.java` source files directly. It executes compiled bytecode.

## JRE

The Java Runtime Environment provides what is needed to run Java programs.

Historically, this meant the JVM plus runtime libraries. For learning, the useful mental model is:

```text
JRE = runtime needed to run Java applications
```

If you only want to run Java software, a runtime is enough. If you want to build Java software, you need the JDK.

## JDK

The Java Development Kit provides what is needed to develop Java programs.

It includes the runtime plus developer tools such as:

- `javac`: compiles Java source into bytecode.
- `java`: runs Java programs.
- documentation and diagnostic tools depending on the distribution.

For this project, learning starts with the JDK because we want to write, compile, run, and understand Java programs.

## Compile vs Run

Compiling transforms source code into bytecode:

```bash
javac Hello.java
```

Running executes bytecode through the JVM:

```bash
java Hello
```

The distinction matters because many Java tools build on top of this flow. Maven, Gradle, IDEs, and frameworks automate parts of it, but they do not remove the underlying model.

## What to Learn First

Learn this before Spring, Maven, Gradle, or application architecture:

- What files Java uses.
- How compilation works.
- How execution works.
- What packages and classes are.
- How the local JDK is installed and selected.

## Practice

Run:

```bash
java --version
javac --version
```

Then answer:

- Which JDK version is installed?
- Is `javac` available?
- Can you explain the difference between `java` and `javac`?
- What artifact does `javac` produce?

## Local Project Check

On 2026-06-29, the local workspace initially had:

- `java`: OpenJDK 25.
- `javac`: 25.
- `mvn`: Apache Maven 3.9.11 running with Java 17.0.2.

That meant the command-line Java toolchain and the Maven runtime were not aligned.

The workspace was then aligned so `java`, `javac`, and Maven all use Java 25.

## Maven Toolchain Observation

Maven itself runs on a JVM. The JVM Maven runs on is not automatically the same JVM reported by `java --version` in every environment.

For this repository, the current Maven learning baseline is Java 25. The earlier mismatch remains useful as a lesson: always verify the runtime used by the build tool instead of assuming it matches the shell.

## Resolved Questions

- Java 25 is the current learning baseline for Maven slices.
- Maven has been aligned to Java 25.

## Open Questions

- When should build tools enter the learning track?
- Should the first exercise use Maven immediately, given the user's current level?
