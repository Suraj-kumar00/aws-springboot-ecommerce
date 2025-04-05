# Stage 1: Build JAR using Maven with OpenJDK 21
FROM maven:3.9-eclipse-temurin-21 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run the app using OpenJDK
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Create necessary directories
RUN mkdir -p /app/static/img/product_img \
    && mkdir -p /app/static/img/category_img \
    && mkdir -p /app/static/img/profile_img

# Copy files from builder
COPY --from=builder /app/target/Shopping_Cart-0.0.1-SNAPSHOT.jar /app/Shopping_Cart-0.0.1-SNAPSHOT.jar

# Set permissions
RUN chmod -R 777 /app/static/img

# Expose port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "Shopping_Cart-0.0.1-SNAPSHOT.jar"]