Contexte du projet

Une entreprise souhaite mettre en place une API REST pour gérer son catalogue musical. L'API doit permettre la gestion des albums et chansons avec différents niveaux d'accès (USER/ADMIN) via une authentification sécurisée stateless. L'architecture technique repose sur Spring Boot et intègre les pratiques DevOps modernes

​

Entités Principales :
Album : titre (String), artiste (String), annee (Integer)
Chanson : titre (String), duree (Integer), trackNumber (Integer)
User : login (String), password (String), active (Boolean), roles (Collection

    Un album peut avoir plusieurs chansons
    Une chanson appartient à un seul album

​

Fonctionnalités Requises :

​

Gestion des Albums :
Lister les albums avec pagination (USER ou ADMIN)
Rechercher les albums par titre avec introduction de la pagination et sorting (USER ou ADMIN)
Rechercher les albums par artiste (USER ou ADMIN)
Filtrer les albums par année avec pagination et sorting (USER ou ADMIN)
Ajouter un nouvel album (ADMIN uniquement)
Modifier un album existant (ADMIN uniquement)
Supprimer un album (ADMIN uniquement)

    /api/user/albums/**
    /api/admin/albums/**

​

Gestion des Chansons :
Lister les chansons avec pagination (USER ou ADMIN)
Rechercher les chansons par titre avec introduction de la pagination et sorting (USER ou ADMIN)
Lister les chansons d'un album avec pagination et sorting (USER ou ADMIN)
Ajouter une nouvelle chanson (ADMIN uniquement)
Modifier une chanson existante (ADMIN uniquement)
Supprimer une chanson (ADMIN uniquement)

    /api/user/songs/**
    /api/admin/songs/**

​

Gestion des Utilisateurs :
/api/auth/login (authentification)
POST /api/auth/register (création de compte)
GET /api/admin/users (liste des utilisateurs, ADMIN uniquement)
PUT /api/admin/users/{id}/roles (gestion des rôles, ADMIN uniquement)

​

Sécurité :
Mise en place de Spring Security
Authentification stateless avec JWT
Les URLs /api/admin/* nécessitent le rôle ADMIN
Les URLs /api/user/* nécessitent le rôle USER
Utiliser BCryptPasswordEncoder pour le cryptage des mots de passe ou un autre encoder plus robuste

​

Un bon JWT à créer est un token d'authentification qui :

    Identifie le serveur ou service qui a émis ce JWT via .withIssuer()
    Contient l'identité du client utilisant ce JWT via .withSubject()
    Stocke les rôles/permissions du client via .withArrayClaim() / .withClaim()
    A une durée de validité limitée via .withExpiresAt()
    Est signé de manière sécurisée via .sign() en utilisant HMAC ou RSA

​

Pour tester le contenu du JWT généré il faut utiliser un decodeur de JWT :

    Un décodeur de JWT en ligne comme jwt.io. : Méthode déconseillé car même si ces sites sont généralement fiables, il y a toujours un risque que nos données sensibles soient interceptées ou stockées
    Un décodeur de JWT local/offline : Méthode sécurisé en utilisant Postman, un plugin intellij, une extension VSC ou autres moyens locaux

​

Couches applicatives :

Controller, Service, Repository, DTO, Mapper, Exception, Validation, Utils, Tests ...

​

Technologies et concepts à utiliser :

Spring Boot

REST API

Spring Data

Gestion des exceptions : @ControllerAdvice , exceptions métier personnalisées

Validation : Bean Validation (@Valid, @NotNull, etc.), validateurs personnalisés

Bases de données : Utiliser un SGBD NoSQL : mongoDB tout en gardant Spring Data comme framework de mapping objet document

Jenkins pour l'intégration et le déploiement continu

Conteneurisation avec Docker (Dockerfile, Scripts de démarrage ...)

DockerHub pour stocker l'image Docker générée via Jenkins

​

Exigences techniques à utiliser :

Profiles (dev, prod)
Configuration purement XML ou uniquement avec annotations au choix
Tests unitaires et d'intégration (JUnit et Mockito)
Tests de sécurité basiques
Design patterns (Repository, DTO, Mapper)
Système de logging (LOGGER)
Validations métier
Gestion des transactions
Fonctionnalités Java : Stream API, Lambda expressions, Java Time API, Optional, Collection API

​

Outils de travail :

Git avec branches, IDE au choix, JIRA + Scrum, Lombok, Spring Boot DevTools, SonarLint, Debugger, Tests via Postman, Swagger pour documentation API

​
