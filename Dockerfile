# Etapa 1: build del proyecto con Maven
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copiar pom y descargar dependencias primero (mejora el cache)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiar el resto del código y compilar
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: imagen final con Java runtime
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copiar el jar generado desde la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto de la app (ajustalo si usás otro)
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
