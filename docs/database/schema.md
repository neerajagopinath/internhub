# Database Schema

## Overview

InternHub currently uses MySQL as the relational database.

The schema is designed to support:

- authentication
- intern management
- mentor workflows
- project tracking
- future scalability

---

# Current Tables

## users

Stores authentication and user account information.

| Column | Type | Description |
|---|---|---|
| id | BIGINT | Primary key |
| name | VARCHAR | User full name |
| email | VARCHAR | Unique email |
| password | VARCHAR | Encrypted password |
| role | VARCHAR | User role |

---

## interns

Stores intern-related information.

| Column | Type | Description |
|---|---|---|
| id | BIGINT | Primary key |
| name | VARCHAR | Intern name |
| email | VARCHAR | Intern email |
| domain | VARCHAR | Internship domain |
| status | VARCHAR | Current internship status |

---

# Relationships

Current schema design is intentionally simple and modular.

Planned future relationships:

```plaintext
Mentor
   ↓
Interns

Project
   ↓
Interns

Tasks
   ↓
Interns
```

---

# Future Planned Tables

Planned schema expansion includes:

- mentors
- projects
- tasks
- attendance
- notifications
- evaluations

---

# Design Principles

Current schema design follows:

- normalized structure
- modular entities
- scalable relationships
- separation of authentication and business logic
- future extensibility

---

# ORM Layer

Database interaction is handled using:

- Spring Data JPA
- Hibernate ORM

This reduces manual SQL management and improves entity mapping consistency.