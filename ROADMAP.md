# Roadmap

## Status

Draft for review.

## Roadmap Philosophy

This roadmap is a direction-setting document, not a complete task inventory.

The project should keep a clear long-term shape while creating detailed issues only when the next work is understood well enough to act on. Planning too far ahead would create noise, false certainty, and maintenance overhead.

The roadmap therefore uses three levels:

- Seasons: broad phases of the project.
- Focus areas: the main outcomes expected in each season.
- Near-term issues: concrete work for the next few steps.

## Current Position

The project is in Season 1: Engineering Foundations.

The repository foundation is complete, and the first two foundational documents have initial drafts:

- Project Charter.
- Vision.

The next priority is to start structured Java learning while keeping the remaining process work lightweight and just-in-time.

## Season 1 - Engineering Foundations

### Purpose

Create the operating model that will guide all future engineering work.

Season 1 is about judgment, documentation, workflow, decision-making, AI collaboration, and foundational backend learning. It intentionally avoids product application implementation until the project has enough structure to support it well.

### Outcomes

By the end of Season 1, the repository should define:

- Why the project exists.
- How work is planned and reviewed.
- How decisions are recorded.
- How AI collaborators should behave.
- How documentation should be structured.
- How architecture proposals should be discussed.
- How learning should be captured over time.
- How Java foundations are understood before frameworks are introduced.

### Current Foundation

- `PROJECT_CHARTER.md`: initial draft complete.
- `VISION.md`: initial draft complete.
- `ROADMAP.md`: initial draft complete.
- `STATUS.md`: initial draft complete.
- `ENGINEERING_MANIFESTO.md`: initial draft complete.
- `docs/learning/java-foundations-track.md`: started.
- `knowledge-base/java/jvm-jdk-jre.md`: initial note complete.
- `knowledge-base/java/maven-toolchain.md`: initial note complete.
- `learning/java/toolchain-slice`: first Maven slice created.
- `knowledge-base/java/modern-java-essentials.md`: initial note complete.
- `learning/java/language-essentials-slice`: second Maven slice created.
- Java learning Maven baseline aligned to Java 25.

### Planned Foundation Work

- `AGENTS.md`: repository-level instructions for AI collaborators.
- `.ai/agents/*`: role-specific AI collaboration guides.
- `templates/adr-template.md`: architecture decision record template.
- `templates/rfc-template.md`: request for comments template.
- `templates/journal-template.md`: weekly reflection template.
- `docs/glossary/`: shared vocabulary for the project.

### Learning Work

- Java toolchain alignment.
- Maven-based learning slices.
- Modern Java language essentials.
- Object modeling and package boundaries.
- Collections, streams, and error handling.
- Testing and refactoring.

### Not Yet

Season 1 should not include:

- Product application code.
- Microservices.
- Cloud infrastructure.
- Kafka-based systems.
- Database schema design.
- Frontend implementation.
- Production deployment pipelines.

Those topics matter, but they need the foundation first.

### Exit Criteria

Season 1 is complete when:

- The foundational documents have coherent initial drafts.
- The issue, branch, PR, and review workflow feels natural.
- The repository explains itself without requiring chat history.
- ADR and RFC templates exist.
- AI collaboration rules are explicit enough to guide future work.
- The next season can start with a clear project candidate.

## Season 2 - Core Platform

### Purpose

Start building the first real software system using the operating model from Season 1.

### Likely Focus Areas

- Define the first product or platform concept.
- Choose the first architecture style.
- Establish the initial backend foundation.
- Introduce tests and local development workflow.
- Record the first architecture decisions.

### Planning Rule

Do not create detailed Season 2 issues until Season 1 has produced enough clarity.

## Season 3 - Distributed Systems

### Purpose

Introduce more advanced backend and integration patterns only after a strong core exists.

### Likely Focus Areas

- Messaging and event-driven design.
- Kafka.
- Reliability patterns.
- Integration boundaries.
- Observability.

## Season 4 - Cloud and Operations

### Purpose

Move from local/system design toward deployable, observable, operable systems.

### Likely Focus Areas

- AWS.
- Infrastructure as Code.
- CI/CD maturity.
- Containers.
- Kubernetes or OpenShift.
- Runtime operations.

## Season 5 - Portfolio Hardening

### Purpose

Turn the accumulated work into a polished, reviewable engineering portfolio.

### Likely Focus Areas

- Documentation quality.
- Architecture narratives.
- Demo environments.
- Case studies.
- Retrospectives.
- Public presentation.

## Near-Term Backlog

Only the next few concrete issues should be kept ready at any given time:

1. Continue object modeling, package boundaries, collections, streams, and error handling using the Java 25 baseline.
2. Use Java 25-specific language features only when they add modeling or testing value.
3. Define AI collaboration rules when they become necessary for learning workflow.
4. Create ADR template.
5. Create RFC template.

## Planning Rules

- Create issues when the outcome is clear enough to describe.
- Keep future work at roadmap level until it becomes actionable.
- Prefer fewer, better-defined issues over a large speculative backlog.
- Update the roadmap when a decision changes the direction of the project.
- Keep the project board focused on current and near-term work.
