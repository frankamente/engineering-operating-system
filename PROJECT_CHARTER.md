# Project Charter

## Status

Draft for review.

## Purpose

Engineering Operating System exists to turn long-term engineering growth into a deliberate, documented, and repeatable practice.

The repository is not a collection of notes. It is the operating system for how engineering work is planned, reasoned about, reviewed, learned from, and improved over time.

## Vision

Build a portfolio-quality engineering system that shows not only what was built, but how decisions were made, how trade-offs were evaluated, and how technical judgment evolved.

The project should become useful in three ways:

- As a personal engineering memory.
- As a reusable operating model for future software projects.
- As evidence of professional engineering maturity for collaborators, reviewers, and recruiters.

## Scope

This repository contains the engineering operating model, documentation system, decision records, templates, journals, and knowledge base for the broader Engineering Operating System initiative.

It may reference future software systems, platforms, services, and experiments, but it is not itself the production application repository.

## Non-Goals

- Build application code before the engineering foundation is clear.
- Create a large documentation archive without ownership or purpose.
- Optimize for speed over clarity, reversibility, and learning.
- Treat AI-generated output as final without human review.
- Use external project management tools when GitHub can provide the required workflow.

## Principles

- The repository is the source of truth.
- Documentation is part of the engineering system, not an afterthought.
- Important decisions should be recorded close to the work.
- Small, reviewed changes are preferred over large unreviewed batches.
- Every artifact should have a reason to exist.
- The domain and learning objective should guide the technology, not the reverse.
- AI collaborators should help clarify reasoning, expose trade-offs, and improve quality.

## Operating Model

Work should follow a lightweight engineering flow:

1. Create or select an issue.
2. Clarify the expected outcome.
3. Create a focused branch.
4. Make the smallest coherent change.
5. Open a pull request.
6. Review the change.
7. Merge to `main`.
8. Update context, decisions, and changelog when relevant.

This flow applies even when there is only one human contributor. The goal is to make professional habits automatic before the project becomes larger.

## Initial Workstreams

### Sprint 0 - Foundation

Create the repository structure, GitHub workflow, labels, milestones, project board, and first official issue.

### Season 1 - Engineering Foundations

Define the foundational documents that will guide future work:

- Project Charter.
- Vision.
- Engineering Manifesto.
- AI collaborator instructions.
- Roadmap.
- Decision and documentation templates.

## Stakeholders

### Owner

The project owner is responsible for final decisions, long-term direction, and keeping the repository aligned with the intended learning path.

### AI Collaborators

AI collaborators assist with research, drafting, implementation, review, and structured critique. They must follow the repository instructions and should not replace human judgment.

### Future Reviewers

Future reviewers may include peers, mentors, hiring teams, or collaborators. The repository should make the reasoning behind the work visible to them.

## Success Criteria

The project is succeeding when:

- The repository remains understandable without relying on chat history.
- Decisions are easy to trace.
- Work is organized through issues, branches, and pull requests.
- Documentation improves the quality of future work.
- The project demonstrates increasing engineering maturity over time.

## Current Constraints

- The project starts as a single repository under a personal GitHub account.
- The repository should avoid unnecessary cost.
- Artifacts should be written in English.
- Discussion and planning may happen in Spanish, but committed repository content should use English.

## Review Questions

- Is the scope narrow enough for the first season?
- Are the non-goals strong enough to prevent premature application work?
- Are the operating principles actionable rather than decorative?
- Does the charter make future decisions easier?
