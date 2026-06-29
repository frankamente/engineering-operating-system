# Modern Java Essentials

## Status

Initial note.

## Scope

This note captures the Java language features practiced in the second Maven learning slice.

The target is Java 17, not Java 25. That is enough for useful modern Java practice while Maven still runs on Java 17 locally.

## Records

Records are useful for small immutable data carriers.

Good record practice includes:

- validate invariants in compact constructors;
- normalize values at construction boundaries;
- defensively copy mutable inputs such as collections;
- keep behavior close to the data when the behavior is simple and intrinsic.

Records are not a replacement for every domain object. They are best when identity, mutation, and complex lifecycle are not central.

## Sealed Types

Sealed interfaces and classes model a finite set of allowed implementations.

They are useful for result shapes such as:

- accepted vs rejected;
- ready vs blocked;
- completed vs too large;
- known command or event variants.

The benefit is not just syntax. The code documents that the set of outcomes is intentionally closed.

## Switch Expressions

Switch expressions make branching explicit and expression-oriented.

They are especially useful with enums when every case should be handled deliberately.

## Streams and Collections

Streams are useful for collection transformations:

- filtering;
- sorting;
- grouping;
- mapping;
- flattening nested collections;
- collecting immutable results.

They should make the data flow clearer. If the stream becomes hard to read, a plain loop is still a good tool.

## Optional

`Optional` is useful for lookup results that may not exist.

It should not be used for every nullable value, and it should not usually be used as a record field in simple domain data.

## Practice Rule

Use modern Java features when they make invariants, result shapes, or collection flow clearer. Do not use them merely to prove that they exist.
