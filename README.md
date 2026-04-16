# Converter Platform (Full-Stack Application)

## Overview

This project is a full-stack application designed to handle structured data conversion workflows between systems. It simulates real-world enterprise scenarios involving data validation, transformation, and persistence across multiple layers.

The system is built using a Java Spring Boot backend and an Angular frontend, following a modular and scalable architecture.

## Tech Stack

**Backend:**
- Java
- Spring Boot
- REST APIs

**Frontend:**
- Angular (TypeScript)
- HTML, CSS

**Database:**
- MySQL

**Tools & Infrastructure:**
- Git
- Postman / Swagger
- IntelliJ IDEA

## Features

- RESTful API for structured data conversion workflows
- End-to-end data flow from UI → backend → database
- Input validation and error handling for data integrity
- Modular architecture (Controller → Service → Repository)
- Frontend integration with backend APIs
- Scalable design for future enhancements

## Architecture

The application follows a layered architecture:

Frontend (Angular)
    ↓
REST API (Spring Boot Controller)
    ↓
Service Layer (Business Logic)
    ↓
Repository Layer (Database Access)
    ↓
MySQL Database

Key principles:
- Separation of concerns
- Modular design
- Scalable and maintainable structure

## Getting Started

### Prerequisites
- Java 17+
- Node.js & npm
- MySQL
- Angular CLI

---

### Backend Setup (Spring Boot)

1. Navigate to backend directory:
```bash
cd backend

./mvnw spring-boot:run
