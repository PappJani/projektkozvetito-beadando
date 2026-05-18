# Alap image, ami tartalmazza a Java 21-et (ugyanaz, amit te is használsz)
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
# Bemásoljuk a lefordított programot a konténerbe
COPY target/*.jar app.jar
EXPOSE 8080
# Indítási parancs
ENTRYPOINT ["java", "-jar", "app.jar"]