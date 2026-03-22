# 🚀 Spring Boot API Rate Limiter

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/SpringBoot-Backend-green)
![Maven](https://img.shields.io/badge/Maven-Build-blue)
![Docker](https://img.shields.io/badge/Docker-Containerization-blue)
![Cloud](https://img.shields.io/badge/Deployed%20on-Render-purple)
![License](https://img.shields.io/badge/License-MIT-yellow)

A lightweight **API Rate Limiter** built using **Java and Spring Boot** to protect backend services from excessive API requests.

This project limits the number of requests a client can make within a fixed time window, preventing API abuse and improving backend stability.

---

# 🌐 Live API

Test the deployed API here:

https://springboot-api-rate-limiter.onrender.com/api/test

Refresh the page multiple times to see the **rate limiter blocking excessive requests**.

---

# ✨ Features

✔ API Request Rate Limiting
✔ Lightweight In-Memory Implementation
✔ Prevents API abuse
✔ REST API endpoint for testing
✔ Dockerized application
✔ Cloud deployed backend

---

# 🛠 Tech Stack

| Technology  | Usage                |
| ----------- | -------------------- |
| Java 17     | Programming Language |
| Spring Boot | Backend Framework    |
| Maven       | Build Tool           |
| Docker      | Containerization     |
| Render      | Cloud Deployment     |
| REST API    | API Architecture     |

---

# 📂 Project Structure

```
springboot-api-rate-limiter
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── api_rate_limiter
│   │   │       ├── controller
│   │   │       │   └── ApiController.java
│   │   │       │
│   │   │       ├── service
│   │   │       │   └── RateLimiterService.java
│   │   │       │
│   │   │       └── ApiRateLimiterApplication.java
│   │   │
│   │   └── resources
│   │       └── application.properties
│
├── Dockerfile
├── pom.xml
└── README.md
```

---

# 🏗 Architecture Diagram

```
Client / Browser
        │
        │ HTTP Request
        ▼
Spring Boot Controller
(ApiController)
        │
        ▼
RateLimiterService
(Request Counting Logic)
        │
        ▼
Response
(API Allowed / Blocked)
```

---

# 🔄 API Request Flow

```
Client Request
      │
      ▼
Check Request Count
      │
      ├── Within Limit
      │        │
      │        ▼
      │   Allow Request
      │
      └── Limit Exceeded
               │
               ▼
        Block Request
```

---

# 🌐 API Endpoint

### Test Endpoint

GET /api/test

Example:

https://springboot-api-rate-limiter.onrender.com/api/test

---

# 📥 Example Response

### Successful Request

```
API request successful 🚀
```

### Limit Exceeded

```
Too many requests ❌
```

---

# 🐳 Docker Deployment

The application is containerized using Docker and deployed on Render.

Dockerfile used:

```
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
```

---

# ▶ Run Locally

Clone repository

```
git clone https://github.com/ChinmayaKumarSingh/springboot-api-rate-limiter.git
```

Navigate to project

```
cd springboot-api-rate-limiter
```

Run application

```
mvn spring-boot:run
```

Open browser

```
http://localhost:8080/api/test
```

---

# 📈 Future Improvements

• Redis based distributed rate limiter
• User based request tracking
• Swagger API documentation
• Request logging and monitoring
• Rate limiting per API endpoint

---

# 👨‍💻 Author

**Chinmaya Singh**

---

# 📜 License

This project is licensed under the **MIT License**.

Copyright (c) 2026 Chinmaya Kumar Singh


---

⭐ If you found this project useful, please consider giving it a **star on GitHub**.
