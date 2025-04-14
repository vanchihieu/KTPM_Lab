# Build stage
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app

# Copy maven settings and pom first for better layer caching
COPY pom.xml .

# Configure Maven to use mirrors and add retry/timeout settings
RUN mkdir -p ~/.m2 \
    && echo "<settings><mirrors><mirror><id>central-https</id><url>https://repo1.maven.org/maven2</url><mirrorOf>central</mirrorOf></mirror></mirrors></settings>" > ~/.m2/settings.xml

# Install dependencies with retries and increased timeout
RUN mvn dependency:go-offline -B \
    -Dmaven.wagon.http.retryHandler.count=5 \
    -Dmaven.wagon.http.pool=false \
    -Dmaven.wagon.httpconnectionManager.ttlSeconds=180 \
    -Dmaven.wagon.http.ssl.insecure=true \
    -Dmaven.wagon.http.ssl.allowall=true \
    || mvn dependency:go-offline -B

# Copy source and build
COPY src ./src
RUN mvn clean package -DskipTests --no-transfer-progress

# Runtime stage
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/api-gateway-1.0-SNAPSHOT.jar api-gateway.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "api-gateway.jar"]