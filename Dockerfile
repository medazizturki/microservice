FROM openjdk:23
EXPOSE 8080
ADD target/GestionTournoi-0.0.1-SNAPSHOT.jar tournoi.jar
ENTRYPOINT ["java","-jar","tournoi.jar"]