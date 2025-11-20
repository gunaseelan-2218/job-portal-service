# 🧑‍💼 Job Portal Backend (Spring Boot + PostgreSQL)

A backend service for managing job postings, user registration, and applications.  
Built using **Spring Boot**, **JWT Authentication**, and **PostgreSQL**.

---

## 🚀 Features

### 🔓 Public Access
- View available jobs (no login required)
- Register new user
- Login using username & password

### 👤 User Access
- View and update profile
- Apply for jobs
- View applied job list
- Delete account

### 🛠️ Admin Access
- Create, update, and delete job postings
- View all registered users
- View all job applications

---

## 🧩 Tech Stack

| Layer | Technology Used |
|--------|-----------------|
| **Backend Framework** | Spring Boot (Java 17+) |
| **Database** | PostgreSQL |
| **Authentication** | JWT (JSON Web Token) |
| **Build Tool** | Maven |
| **ORM** | Spring Data JPA |
| **Mail Support** | Spring Boot Mail |
| **Documentation** | Swagger / OpenAPI |
| **Utilities** | Lombok |

---

## 🏗️ Project Modules

| Module | Description |
|--------|-------------|
| `AuthController` | Handles user registration & login |
| `UserController` | Manages user profile and account |
| `JobController` | Manages job listings (Admin & Public access) |
| `ApplicationController` | Handles job applications |

---

## ⚙️ API Endpoints

### 🔐 Authentication
| Method | Endpoint | Description |
|--------|-----------|-------------|
| `POST` | `/auth/register` | Register a new user |
| `POST` | `/auth/login` | Login with credentials and get JWT token |

### 👤 User
| Method | Endpoint | Description |
|--------|-----------|-------------|
| `GET` | `/user/profile` | Get user profile |
| `PUT` | `/user/update` | Update profile |
| `DELETE` | `/user/delete` | Delete account |

### 💼 Jobs
| Method | Endpoint | Description |
|--------|-----------|-------------|
| `GET` | `/jobs` | Get all jobs |
| `POST` | `/jobs/create` | Create a new job (Admin) |

---

## 🗄️ Database Schema (PostgreSQL)

- `users`
- `user_profile`
- `jobs`
- `job_applications`

---

## 🚀 How to Run Locally

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/<your-username>/job-portal-backend.git
cd job-portal-backend
