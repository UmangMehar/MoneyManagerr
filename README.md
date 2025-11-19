💰 Money Manager – Backend (Spring Boot)
A secure and scalable personal finance management backend built using Spring Boot, featuring authentication, categories, income, expenses, filtering, analytics, and scheduled email notifications.

🚀 Features
✅ Authentication & Profile
User registration with email activation
Login with JWT token generation
Secure password hashing (BCrypt)
Public profile fetch API

✅ Categories
Create category
Fetch all categories for current user
Fetch categories by type (income/expense)
Update category

✅ Expenses
Add expense
Get current month expenses
Delete expense
Get latest 5 expenses
Filter expenses by date, keyword, sort

✅ Income
Add income
Get current month incomes
Delete income
Get latest 5 incomes
Filter incomes

✅ Filter API
Filter income/expense based on:
Start date
End date
Keyword
Sorting (ASC/DESC)
Type (income/expense)

✅ Dashboard
Total balance
Total income
Total expense
Latest 5 incomes & expenses
Combined recent transactions

✅ Email Notifications
Daily reminder at 10 PM
Daily expense summary at 11 PM
Email sent via Brevo SMTP API

✅ Security
JWT Authentication
Custom JWT filter
Stateless sessions
Custom UserDetailsService
BCrypt password hashing
CORS enabled

🛠 Tech Stack
Backend: Spring Boot
Security: Spring Security + JWT
Database: MySQL / PostgreSQL
Email: Brevo SMTP API
Build Tool: Maven
Scheduler: Spring @Scheduled
Language: Java 17+

🔌 API Endpoints (Quick Overview)
🔐 Auth
Method	Endpoint	Description
POST	/register	Register user
GET	/activate?token=	Activate account
POST	/login	Login & get JWT

👤 Profile
Method	Endpoint	Description
GET	/profile	Get current user profile

🗂 Categories
Method	Endpoint	Description
POST	/categories	Create category
GET	/categories	Get all categories
GET	/categories/{type}	Get categories by type
PUT	/categories/{id}	Update category

💸 Expenses
Method	Endpoint	Description
POST	/expenses	Add expense
GET	/expenses	Get current month expenses
DELETE	/expenses/{id}	Delete expense

💰 Income
Method	Endpoint	Description
POST	/incomes	Add income
GET	/incomes	Get current month income
DELETE	/incomes/{id}	Delete income

🔎 Filtering
Method	Endpoint	Description
POST	/filter	Filter income/expense

📊 Dashboard
Method	Endpoint	Description
GET	/dashboard	Get analytics + latest transactions


src/main/java/in/umangcraft/moneymanager/
│── controller/
│── service/
│── entity/
│── dto/
│── repository/
│── security/
│── config/
│── util/


🔐 JWT Authentication Workflow
User logs in
Backend validates credentials
JWT token is generated
Token is included in Authorization header
JwtRequestFilter validates token on every request

🕒 Scheduled Jobs
Time (IST)	Task
10:00 PM	Send reminder to add income/expense
11:00 PM	Send daily expense summary

⚙️ Environment Variables
Add to application.properties:
jwt.secret=YOUR_SECRET
app.activation.url=YOUR_FRONTEND_URL
money.manager.frontend.url=YOUR_FRONTEND_URL

brevo.api.key=YOUR_BREVO_API_KEY
brevo.from.email=YOUR_SENDER_EMAIL
brevo.from.name=Money Manager


mvn clean install
mvn spring-boot:run


📦 Build & Run
mvn clean install
mvn spring-boot:run

🤝 Contributing
Feel free to open issues or PRs.

⭐ Support
If you like this project, give it a star on GitHub!
