# Étape 1 : Utiliser une image de base avec Java 17
FROM maven:3.8.3-openjdk-17 AS builder

# Étape 2 : Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Étape 3 : Copier le fichier JAR généré par IntelliJ dans le conteneur
COPY target/*.jar app.jar

# Étape 4 : Exposer le port de l'application Spring Boot
EXPOSE 8080

# Étape 5 : Commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
