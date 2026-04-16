# Converter Platform (Full-Stack Application)

## Highlights
- Improved backend performance by ~80% (22.7s → 4.3s) by eliminating N+1 queries  
- Reduced frontend API load by ~58% through optimized Angular data-fetching strategies  
- Full-stack architecture using Angular + Spring Boot  
- Production-style data flow, validation, and error handling  

---

## Overview

This project is a full-stack application designed to handle structured data conversion workflows between systems. It simulates real-world enterprise scenarios involving data validation, transformation, and persistence across multiple layers.

The system is built using a Java Spring Boot backend and an Angular frontend, following a modular and scalable architecture.

---

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

---

## Features

- RESTful API for structured data conversion workflows  
- End-to-end data flow from UI → backend → database  
- Input validation and error handling for data integrity  
- Modular architecture (Controller → Service → Repository)  
- Frontend integration with backend APIs  
- Scalable design for future enhancements  

---

## Architecture

Frontend (Angular)
↓
REST API (Spring Boot Controller)
↓
Service Layer (Business Logic)
↓
Repository Layer (Database Access)
↓
MySQL Database


**Key principles:**
- Separation of concerns  
- Modular design  
- Scalable and maintainable structure  

---

## Getting Started

### Prerequisites
- Java 17+
- Node.js & npm
- MySQL
- Angular CLI

---

## Backend Setup (Spring Boot)

cd backend
./mvnw spring-boot:run

Backend runs on:
http://localhost:8080

## Frontend Setup (Angular)

cd frontend
npm install
ng serve

Frontend runs on:
http://localhost:4200

### Frontend Responsibilities

- UI rendering and user interaction
- API communication with backend services
- Data presentation and state handling

### What I Learned

- Designing scalable backend systems using Spring Boot
- Structuring full-stack applications with clear data flow
- Handling API integration between frontend and backend
- Implementing validation and error handling
- Applying modular architecture for maintainability

### Future Improvements

- Add authentication and authorization (JWT)
- Implement logging and monitoring enhancements
- Improve UI/UX with advanced Angular components
- Deploy to AWS or cloud platform
- Add unit and integration testing

---

This version will:
- Render perfectly on GitHub  
- Match your CV’s strength (performance + systems thinking)  
- Feel like a **real production-style project**, not a tutorial  

If you want next, I can help you add:
- API endpoint examples (very strong signal)  
- Screenshots section (huge for recruiters)
