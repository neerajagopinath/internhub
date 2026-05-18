# Backend Architecture

## Overview

InternHub backend follows layered architecture using Spring Boot.

Architecture layers:

Controller
↓
Service
↓
Repository
↓
Database

---

## Controller Layer

Responsible for:
- handling HTTP requests
- validating request bodies
- returning responses

Example:
- AccountController
- InternController

---

## Service Layer

Responsible for:
- business logic
- validations
- workflows
- orchestration

Example:
- signup logic
- duplicate email checks
- intern processing

---

## Repository Layer

Responsible for:
- database interaction
- JPA operations
- query abstraction

Uses:
- Spring Data JPA
- Hibernate

---

## DTO Layer

DTOs are used to:
- separate API contracts from entities
- avoid exposing database models directly
- structure request/response payloads

---

## Request Lifecycle

Frontend Request
↓
Controller
↓
Service
↓
Repository
↓
Database
↓
Response Returned

---