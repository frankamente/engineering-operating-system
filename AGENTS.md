# AGENTS.md

This file defines how AI collaborators should work inside this repository.

## Repository Source of Truth

The repository is the source of truth for project memory.

Do not rely on chat history for durable project state. Update repository artifacts when a decision, convention, or project state changes.

## Language

Repository artifacts should be written in English.

Discussion with the project owner may happen in Spanish.

## Workflow

Follow the issue -> branch -> pull request -> review -> merge workflow.

Keep issues focused and near-term. Do not create a large speculative backlog.

## Diagrams

All diagrams created in this repository must use Mermaid.

Use Mermaid fenced code blocks in Markdown files or `.mmd` files as the editable source of truth.

Do not introduce diagram source formats such as draw.io, PlantUML, Graphviz, binary images, or hand-drawn SVG for repository diagrams. If a rendered image is ever needed for presentation, keep the Mermaid source beside it and treat the Mermaid source as canonical.
