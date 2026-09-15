# Student Stream Selection Portal 🎓

A modern, full-stack web application designed for automated high school stream selection, student management, academic qualification evaluation, management approval workflows, and admission fee processing.

---

## 🌟 Features

- **Student Registration & Mark Entry**: Simple interface for students to enter board marks across key subjects (Mathematics, Science, English, Social Science).
- **Automated Stream Selection & Evaluation**: Real-time evaluation of student eligibility for Science, Commerce, and Arts streams based on cut-off criteria.
- **Management Approval Workflow**: Dedicated dashboard for management to review edge cases, grant seat upgrades, or approve stream allocations.
- **Integrated Fee Payment System**: Process admission payments with support for multiple payment methods (UPI, Cards, Net Banking) and status tracking.
- **Recheck Request Mechanism**: Students can request paper or evaluation rechecks to recalculate stream eligibility.
- **Comprehensive Search & Analytics**: Search students by name, stream, or admission status (Approved, Pending Payment, Recheck Requested).
- **Automated Unit & End-to-End Testing**: Includes a full Jest + React Testing Library test suite and Cypress E2E coverage.

---

## 🛠️ Tech Stack

### Frontend
- **Framework**: Next.js 14
- **Language**: TypeScript
- **Styling**: Tailwind CSS
- **Form Validation**: React Hook Form
- **HTTP Client**: Axios API Service Wrapper
- **Testing**: Jest, React Testing Library, Cypress

### Backend
- **Framework**: Spring Boot 3.4.3
- **Language**: Java 17+
- **Persistence**: Spring Data MongoDB
- **Architecture**: Controller-Service-Repository Pattern with DTO Mapping

### Database
- **Engine**: MongoDB (running locally on `mongodb://localhost:27017` or via MongoDB Atlas)

---

## 📁 Repository Structure

```
student-stream-selection/
├── backend/                  # Spring Boot Java REST API backend
│   ├── src/main/java/        # Controllers, Services, Repositories, Entities & DTOs
│   │   └── com/studentportal/
│   │       ├── config/       # Web CORS & Security configurations
│   │       ├── controlller/  # REST APIs: StudentController (/api/students)
│   │       ├── dto/          # Request & Response Data Transfer Objects
│   │       ├── entity/       # MongoDB document models (Student, SubjectMark)
│   │       ├── enums/        # Stream, Board, ApprovalStatus, StudentStatus, PaymentStatus
│   │       ├── mappper/      # Entity <-> DTO Mapping logic
│   │       ├── repository/   # Spring Data MongoDB Repositories
│   │       ├── service/      # Business logic & qualification calculations
│   │       └── util/         # Student mark calculation utilities
│   ├── src/main/resources/   # application.properties configuration
│   ├── pom.xml               # Maven dependencies configuration
│   └── mvnw / mvnw.cmd       # Maven Wrapper
│
├── frontend/                 # Next.js 14 TypeScript web frontend
│   ├── pages/
│   │   ├── index.tsx         # Portal dashboard & navigation overview
│   │   ├── register.tsx      # Student registration & marks entry page
│   │   ├── select-stream.tsx # Stream selection request form
│   │   ├── approve.tsx       # Management approval interface
│   │   ├── payment.tsx       # Admission fee payment gateway page
│   │   ├── recheck.tsx       # Recheck request submission page
│   │   └── students/         # Student listing and detailed profile view
│   ├── components/           # FormInput, Select, Button, Layout components
│   ├── services/             # Axios API service (`services/api.ts`)
│   ├── styles/               # Global Tailwind CSS styles
│   ├── cypress/              # Cypress End-to-End test suites
│   ├── __tests__/            # Jest component unit tests
│   ├── package.json          # Dependencies & npm scripts
│   └── jest.config.js        # Jest testing configuration
│
├── .github/
│   └── workflows/ci.yml     # GitHub Actions CI pipeline
├── .gitignore                # Global workspace ignore file
└── README.md                 # Project documentation
```

---

## 🚀 Quick Start

### 1. Prerequisites
- **Java**: JDK 17 or higher
- **Node.js**: v18.0 or higher (`npm` installed)
- **MongoDB**: Running locally on port `27017` or configured via `backend/src/main/resources/application.properties`

---

### 2. Run the Backend

```bash
cd backend
./mvnw spring-boot:run
```

> The REST API server will start on `http://localhost:8080`.

To run backend automated tests:
```bash
./mvnw test
```

---

### 3. Run the Frontend

```bash
cd frontend
npm install
npm run dev
```

> Open [http://localhost:3000](http://localhost:3000) in your browser to view the Student Portal UI.

To execute frontend unit & E2E tests:
```bash
# Run unit tests with Jest
npm test

# Run End-to-End tests with Cypress
npx cypress run
```

---

## 📡 REST API Reference

Base URL: `http://localhost:8080/api/students`

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/save` | Register a new student with subject marks |
| `POST` | `/select-stream` | Submit stream selection preferences & evaluate eligibility |
| `POST` | `/approve` | Process management approval or stream upgrade |
| `POST` | `/payment` | Process admission fee payment |
| `POST` | `/recheck` | Request paper/marks re-evaluation |
| `GET` | `/all` | Retrieve all student records |
| `GET` | `/{studentId}` | Fetch detailed student profile by Student ID |
| `GET` | `/search/name/{name}` | Search student records by student name |
| `GET` | `/search/stream/{stream}` | Filter student records by stream (Science, Commerce, Arts) |
| `GET` | `/search/status/{status}` | Filter students by status |
| `GET` | `/management-pending` | List students awaiting management review |
| `GET` | `/payment-pending` | List students awaiting payment completion |

---

## 📄 License

This project is licensed under the MIT License.
