# Learning Inventory

## Purpose

This document is the learning map for the Engineering Operating System.

It is not a task backlog. The backlog should stay small and near-term. This inventory exists so the full learning direction is visible without turning every future topic into an issue.

## Planning Rule

Use three levels:

- Inventory: everything worth learning eventually.
- Track: a coherent learning area with several modules.
- Issue: one concrete, testable next step.

Do not create issues for the full inventory. Create issues only for the next few learning steps.

## Current Focus

Continue with Java foundations using the Java 25 Maven baseline.

The next best learning work is still framework-free:

1. Object modeling and package boundaries.
2. Collections, streams, validation, and error handling.
3. Testing and refactoring.
4. Maven structure and build design.

Spring Boot, distributed systems, cloud, and operations matter, but they should come after stronger Java and backend foundations.

## Learning Areas

### Java Foundations

Goal: become fluent enough in Java to reason about backend code without hiding behind frameworks.

Topics:

- Object modeling.
- Value objects and invariants.
- Packages, visibility, cohesion, and boundaries.
- Records, sealed types, enums, and switch expressions.
- Generics.
- Collections and streams.
- Optional.
- Exceptions, result types, and error handling.
- Immutability and defensive copies.
- Refactoring.
- JVM basics.
- Concurrency fundamentals.
- Virtual threads from the Java side.

Current baseline:

- Java 25.
- Maven compiler release 25.
- Test-backed learning slices.

### Testing

Goal: use tests as a design tool, not only as correctness checks.

Topics:

- JUnit Jupiter.
- Test naming and behavior-focused assertions.
- Fixtures and test data builders.
- Edge cases and boundary tests.
- Refactoring under test protection.
- Mockito and test doubles.
- Integration tests.
- Testcontainers.
- Contract tests.
- Mutation testing.
- Property-based testing.

### Build Tooling

Goal: understand how professional Java projects are built, verified, and evolved.

Topics:

- Maven lifecycle.
- Dependency management.
- Plugin configuration.
- Multi-module projects.
- Build profiles.
- Dependency convergence.
- CI checks.
- Versioning and release basics.

### Backend Fundamentals

Goal: learn backend mechanics before adopting heavier frameworks.

Topics:

- HTTP.
- REST API design.
- JSON serialization.
- Validation.
- Error contracts.
- Configuration.
- Logging.
- Observability basics.
- CLI/library exercises before web services.

### Spring Boot and Modern Spring

Goal: learn Spring Boot as a professional backend platform, including the modern Spring Boot 4 / Spring Framework 7 era, not only old controller-service-repository patterns.

Foundation topics:

- Dependency injection and the application context.
- Auto-configuration.
- Configuration properties.
- Profiles and environment.
- Spring MVC.
- Validation.
- Error handling.
- Actuator.
- Observability with Micrometer.
- Configuration and test slices.

Modern Spring topics to explicitly learn:

- Spring Boot 4 migration and conventions.
- Spring Framework 7 changes relevant to backend applications.
- Modern testing support.
- `RestTestClient`, `WebTestClient`, and `MockMvc`.
- `@MockitoBean`, `@MockitoSpyBean`, and test bean replacement.
- Application context caching and test performance.
- AOT support for tests.
- REST client generation and interface-based HTTP clients.
- `RestClient`.
- `WebClient`.
- HTTP Service Clients with annotated interfaces and generated client proxies.
- HTTP Service groups and grouped client configuration.
- Error handling in generated REST clients.
- Client timeouts, retries, and resilience boundaries.
- OpenAPI documentation and client generation trade-offs.
- Virtual threads in Spring Boot.
- Detecting pinned virtual threads.
- JDK Flight Recorder and `jcmd` for virtual-thread diagnostics.
- Memory dumps and heap analysis.
- Thread dumps and blocked-thread analysis.
- Startup profiling.
- Performance testing with JMeter.
- Load testing methodology.
- Throughput, latency, percentiles, saturation, and backpressure.
- JVM tuning basics for Spring applications.
- Native image and AOT trade-offs later, when useful.

Important boundary:

Do not start Spring Boot until the Java/domain/testing foundation is strong enough. When Spring begins, learn it through small vertical slices with tests and explicit trade-offs.

### Data

Goal: understand persistence as a design and operational concern.

Topics:

- SQL.
- PostgreSQL.
- Transactions.
- Isolation levels.
- Indexes.
- Query plans.
- Migrations.
- JDBC.
- JPA and Hibernate.
- Spring Data.
- Testcontainers for database tests.

### Architecture

Goal: design systems whose boundaries are understandable and changeable.

Topics:

- Layered architecture.
- Hexagonal architecture.
- Ports and adapters.
- Modular monoliths.
- Domain modeling.
- Use cases and application services.
- Dependency direction.
- ADRs.
- RFCs.
- Mermaid architecture diagrams.
- Trade-off analysis.

### Distributed Systems

Goal: learn distributed behavior after local backend fundamentals are solid.

Topics:

- Messaging.
- Kafka.
- Idempotency.
- Retries.
- Timeouts.
- Dead-letter queues.
- Outbox pattern.
- Sagas and process managers.
- Ordering and partitioning.
- Consistency models.
- Failure modes.

### Operations and Cloud

Goal: understand how systems run, fail, recover, and evolve outside the IDE.

Topics:

- Docker.
- CI/CD.
- Logs, metrics, traces, and dashboards.
- AWS.
- Infrastructure as Code.
- Kubernetes.
- OpenShift.
- Runtime configuration.
- Deployment strategies.
- Incident analysis.

### Professional Engineering Practice

Goal: build habits that make engineering work understandable, reviewable, and durable.

Topics:

- Git and GitHub workflow.
- Issues, branches, pull requests, and reviews.
- Documentation.
- Decision logs.
- ADRs and RFCs.
- Mermaid diagrams.
- Changelogs.
- Status tracking.
- Portfolio narrative.
- AI collaboration.

## Near-Term Recommendation

The next learning issue should be:

`Object Modeling and Package Boundaries`

Expected shape:

- A new Java Maven learning slice.
- A compact but realistic domain.
- Multiple packages with intentional boundaries.
- Validation and error handling.
- Tests that reveal design decisions.
- A short knowledge note and journal entry.
