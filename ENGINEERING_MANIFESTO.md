# Engineering Manifesto

## Status

Draft for review.

## Purpose

This manifesto defines the engineering principles that guide the Engineering Operating System.

It is not a motivational poster. It is a decision aid. When a design, implementation, review, or learning path is unclear, these principles should help decide what to do next.

## Principles

### 1. The Domain Leads the Technology

Technology choices should serve the problem, not the other way around.

Before choosing a framework, platform, architecture style, or tool, clarify the domain, constraints, expected change, and learning objective.

Use this principle when deciding whether a technology is genuinely needed or merely attractive.

### 2. Simplicity Is an Engineering Feature

Simple systems are easier to understand, test, change, operate, and teach.

Prefer the simplest design that preserves the important constraints. Avoid accidental complexity, premature distribution, and abstractions that only make the design look more sophisticated.

Simplicity does not mean shallow. It means every part has a reason to exist.

### 3. Decisions Must Be Traceable

Important decisions should leave a trail.

If a decision affects architecture, process, tooling, data, operations, or long-term direction, record what was decided and why. Use the decisions log for lightweight history and ADRs for deeper architectural decisions.

The goal is not bureaucracy. The goal is future understanding.

### 4. Documentation Is Part of the System

Documentation is not separate from engineering work.

Good documentation preserves reasoning, reduces repeated explanation, improves reviews, and makes future work safer. A change is not complete if the repository no longer explains the current reality.

Keep documentation concise, current, and close to the work it supports.

### 5. Work in Small, Reviewable Changes

Large unreviewed changes hide risk.

Prefer issues, branches, and pull requests that represent one coherent change. Each pull request should be understandable, reviewable, and reversible.

Small changes create momentum without sacrificing discipline.

### 6. Make Trade-Offs Explicit

Every meaningful engineering choice has trade-offs.

When proposing an approach, explain what it improves, what it costs, what it delays, and what it makes harder. Do not hide complexity behind confident language.

Strong engineering judgment is visible in the quality of trade-off analysis.

### 7. Reversibility Matters

Prefer decisions that can be changed when new evidence appears.

Before committing to an expensive direction, ask how difficult it would be to reverse, migrate, or replace. If a decision is hard to reverse, it deserves more evidence and stronger documentation.

Reversibility keeps the project adaptable.

### 8. Measure Before Optimizing

Do not optimize based on vibes.

Before improving performance, reliability, cost, or productivity, define what will be observed and how progress will be recognized. Measurement does not need to be complex, but it should be honest.

Optimization without evidence is often just motion.

### 9. Testing Protects Design

Testing is not only a correctness tool. It is a design feedback mechanism.

Use tests to make behavior explicit, protect important flows, and reveal unclear boundaries. Prefer tests that increase confidence in change over tests that merely increase counts.

Testing strategy should match risk.

### 10. Observability Is Not Optional

Systems should explain themselves while they run.

Logs, metrics, traces, events, dashboards, and operational documentation should be considered part of system design when the project reaches executable software.

If a system cannot be observed, it cannot be operated with confidence.

### 11. Automation Should Remove Repeated Human Risk

Automate repetitive, error-prone, and policy-sensitive work.

Automation should make the desired workflow easier to follow: checks, formatting, tests, releases, dependency updates, and project hygiene. Avoid automation that is clever but hard to understand.

The best automation quietly protects quality.

### 12. AI Is a Collaborator, Not an Authority

AI can accelerate research, drafting, implementation, review, and critique, but it does not own the final judgment.

AI collaborators should expose assumptions, explain alternatives, identify risks, and follow repository standards. Human review remains responsible for direction, acceptance, and accountability.

Use AI to improve thinking, not to bypass it.

### 13. Learning Must Compound

Learning should leave artifacts.

When a useful concept, mistake, trade-off, or pattern appears, capture it where future work can benefit from it. The repository should become more valuable because each piece of work improves the next one.

If learning disappears, it does not compound.

## Review Checklist

Use these questions during reviews:

- Does this change make the repository more truthful?
- Is the chosen approach simpler than the alternatives that would also work?
- Are important trade-offs visible?
- Is the decision traceable if someone returns later?
- Is the change small enough to review confidently?
- Is documentation updated where the project state changed?
- Is AI output being reviewed rather than accepted blindly?
