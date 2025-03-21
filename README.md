# 🛒 DreamShops - Spring Boot E-Commerce Application 🛍️

✨ DreamShops is a fully functional e-commerce platform built with Spring Boot technology. This application allows users to search for products from an online store, add them to a cart, and complete orders. ✨

## 🚀 Features

- 👤 **User Management**: Registration, login, and JWT-based authentication
- 📦 **Product Catalog**: Search, filter, and categorize products by categories
- 🛒 **Cart Functionality**: Add, remove, and change the quantity of products in the cart
- 📋 **Order Management**: Create and track orders
- 🖼️ **Image Management**: Upload and store product images with AWS S3 integration
- 🗄️ **DynamoDB Integration**: Store some data in a NoSQL database
- 🔌 **RESTful API**: Fully functional API interface
- 📚 **Swagger/OpenAPI**: Automatically generated documentation for APIs

## 💻 Technical Stack

- 🔧 **Framework**: Spring Boot 3.x
- ☕ **Programming Language**: Java 21
- 🐘 **Database**: PostgreSQL
- 🧩 **NoSQL Database**: Amazon DynamoDB
- ☁️ **Cloud Services**: AWS S3 (for images)
- 🔒 **Security**: Spring Security and JWT authentication
- 📝 **API Documentation**: Swagger/OpenAPI
- 📦 **Dependency Management**: Maven

## ⚙️ Setup and Usage

### 📋 Requirements

- ☕ JDK 21
- 🛠️ Maven
- 🐘 PostgreSQL
- ☁️ AWS Account (for S3 and DynamoDB)

### 🚀 Running the Application

1. 📥 Clone the project:
   ```
   git clone [project_url]
   cd dream-shops
   ```

2. 🔨 Compile with Maven:
   ```
   mvn clean install
   ```

3. ▶️ Run the application:
   ```
   mvn spring-boot:run
   ```

4. 🌐 Access the API:
   ```
   http://localhost:8080/swagger-ui.html
   ```

## 🔌 API Endpoints

The application provides the following main API endpoints:

- 🔐 **Authentication**: `/api/v1/auth/**`
- 👤 **Users**: `/api/v1/users/**`
- 📂 **Categories**: `/api/v1/categories/**`
- 📦 **Products**: `/api/v1/products/**`
- 🛒 **Cart**: `/api/v1/carts/**`
- 📋 **Orders**: `/api/v1/orders/**`
- 🖼️ **Images**: `/api/v1/images/**`

📚 For complete API documentation, see the Swagger UI: `http://localhost:8080/swagger-ui.html`

## 🔒 Security

The application uses JWT (JSON Web Token) authentication. To obtain a valid token for creating API requests, send your login credentials to the `/api/v1/auth/login` endpoint.

## 👥 Contribution

If you would like to contribute to the project, please submit a pull request. Create your own feature branch from the main branch and submit your changes.

