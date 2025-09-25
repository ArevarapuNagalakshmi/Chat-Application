
# Chat Application Project

## Overview

This project is a **full-stack chat and management platform** built with **React** (frontend) and **Spring Boot** (backend).
It allows users to **register, login, access a dashboard**, and **admins to access an admin panel**. The application uses **JWT authentication** for secure access to protected routes.



## **Features**

* **Home Page:** Landing page with links to Register and Login.
* **Register Page:** User registration with validation.
* **Login Page:** Login with email/password and JWT token generation.
* **Dashboard:** Protected route accessible only after login.
* **Admin Panel:** Protected route accessible only to users with the Admin role.
* **Authentication:** JWT-based token authentication for secure endpoints.
* **Frontend & Backend Integration:** Axios is used for REST API calls.



## **Technologies Used**

**Frontend:**

* React.js
* React Router DOM
* Axios
* CSS (inline styling)

**Backend:**

* Java 17+
* Spring Boot 3
* Spring Security (JWT Authentication)
* Spring Data JPA (for database operations)
* H2 / MySQL database



## **Project Structure**

### **Frontend (React)**

```
chat-app-frontend/
├── public/
│   └── index.html
├── src/
│   ├── components/
│   │   ├── Home.js
│   │   ├── Register.js
│   │   ├── Login.js
│   │   ├── Dashboard.js
│   │   ├── AdminPanel.js
│   │   └── ProtectedRoute.js
│   ├── axiosInstance.js
│   ├── App.js
│   └── index.js
├── package.json
└── .env
```

### **Backend (Spring Boot)**

```
chat-app-backend/
├── src/main/java/com/example/chatapp/
│   ├── controller/
│   │   ├── AuthController.java
│   │   ├── DashboardController.java
│   │   └── AdminController.java
│   ├── security/
│   │   ├── JwtFilter.java
│   │   └── SecurityConfig.java
│   ├── service/
│   │   ├── UserService.java
│   │   └── AuthService.java
│   ├── model/
│   │   └── User.java
│   └── ChatAppApplication.java
├── src/main/resources/
│   ├── application.properties
└── pom.xml
```



## **Setup Instructions**

### **Backend (Spring Boot)**

1. Clone the backend repository:

```bash
git clone <backend-repo-url>
```

2. Navigate to backend folder:

```bash
cd chat-app-backend
```

3. Install dependencies and run the server:

```bash
mvn spring-boot:run
```

4. Server runs at `http://localhost:8080`.

> Make sure database (H2/MySQL) is configured in `application.properties`.



### **Frontend (React)**

1. Clone the frontend repository:

```bash
git clone <frontend-repo-url>
```

2. Navigate to frontend folder:

```bash
cd chat-app-frontend
```

3. Install dependencies:

```bash
npm install
```

4. Create `.env` file and add backend URL:

```env
REACT_APP_API_URL=http://localhost:8080
```

5. Start frontend server:

```bash
npm start
```

6. Open `http://localhost:3000` in your browser.



## **Usage**

1. **Home Page:** Navigate to `/` and click Register/Login.
2. **Register:** Fill in username, email, password, confirm password → submit → redirected to login.
3. **Login:** Enter email/password → receive JWT token → redirected to dashboard.
4. **Dashboard:** Access secured user data.
5. **Admin Panel:** Access admin-specific data (requires Admin role).

> All protected pages require login. JWT token is stored in `localStorage`.



## **Notes**

* Ensure **CORS** is enabled in Spring Boot for frontend requests.
* Backend uses **JWT authentication**; frontend sends token in **Authorization header** using Axios.
* Passwords are validated on frontend (matching password/confirm password) and backend (hashed before saving).



## **Future Enhancements**

* Real-time chat using **WebSocket**.
* Profile management and user roles.
* Responsive design for mobile devices.
* Email verification on registration.



## **Author**

**Nagalakshmi Arevarapu**
Computer Science Graduate | Full Stack Developer





