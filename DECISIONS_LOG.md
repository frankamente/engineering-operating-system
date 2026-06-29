# Decisions Log

## 2026-06-29

- Decision: Start with a single repository instead of a GitHub organization.
  Reason: Avoid unnecessary cost and keep the initial operating model simple.
- Decision: Use this repository as the source of truth for the Engineering Operating System.
  Reason: Long-term project memory should live in version control, not in chat history.
- Decision: Write repository artifacts in English.
  Reason: Practice technical English and keep the project suitable for an international portfolio.
- Decision: Write the Project Charter as the first foundational document.
  Reason: The charter defines purpose, scope, constraints, and operating model before deeper handbooks or templates are created.
- Decision: Write the Vision after the Project Charter.
  Reason: The charter defines the operating frame; the vision explains the long-term purpose that should keep the project coherent over time.
- Decision: Draft the Roadmap before the Engineering Manifesto.
  Reason: The roadmap defines the order and boundaries of Season 1 before adding more principles or standards.
- Decision: Keep detailed issues limited to near-term work.
  Reason: A lightweight backlog preserves direction without creating speculative task maintenance.
- Decision: Add `STATUS.md` as the operational project state.
  Reason: Future agents and humans need a versioned recovery point that survives chat compaction and does not depend on GitHub UI alone.
- Decision: Use the Engineering Manifesto as a decision aid.
  Reason: Principles should help evaluate real engineering choices instead of becoming decorative slogans.
- Decision: Start learning before completing every remaining process artifact.
  Reason: The repository now has enough foundation; continued process work should be justified by learning or building needs.
- Decision: Begin with Java runtime and tooling.
  Reason: Understanding JVM, JDK, compilation, and execution creates a stronger base before frameworks, build tools, or application architecture.
- Decision: Use the installed Java 25 toolchain for the first learning exercises.
  Reason: The local environment already provides both `java` and `javac` version 25, allowing plain JDK practice without setup work.
- Decision: Recalibrate the Java learning track above beginner level.
  Reason: The project owner already has more than beginner-level Java knowledge; learning work should focus on professional backend practice rather than trivial syntax exercises.
- Decision: Make Maven toolchain alignment part of the first Java learning slice.
  Reason: Maven is installed but currently runs on Java 17 while `java` and `javac` report Java 25, which is a real tooling concern worth handling deliberately.
