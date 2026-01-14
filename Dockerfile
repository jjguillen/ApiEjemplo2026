FROM docker.io/eclipse-temurin:25-jre-jammy
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

# windows ->
# podman network create spring-net
# podman run -d --name mariadb -p 3309:3306 --network spring-net -e MARIADB_ROOT_PASSWORD=toor -e MARIADB_DATABASE=springapi -e MARIADB_USER=usuario -e MARIADB_PASSWORD=usuario1234 -v mariadb_data:/var/lib/mysql mariadb:latest

# podman build -t springapiejemplo:1.0 .
# podman run -d --name mariadb -p 3309:3306 -e MARIADB_ROOT_PASSWORD=toor -e MARIADB_DATABASE=springapi -e MARIADB_USER=usuario -e MARIADB_PASSWORD=usuario1234 -v mariadb_data:/var/lib/mysql mariadb:latest

# windows ->
# podman run -p 8080:8080 --network spring-net  --name springapp -d -t springapiejemplo:1.0

# linux ->
# podman run -p 8080:8080 --network host  --name springapp -d -t springapiejemplo:1.0

