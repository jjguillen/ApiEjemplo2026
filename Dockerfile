FROM docker.io/eclipse-temurin:25-jre-jammy
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

# podman build -t springapiejemplo:1.0 .
# podman image list
# podman run -p 8080:8080 --name springapp -d -t springapiejemplo:1.0
# podman stop springapp
# podman start springapp
# podman stats
# podman logs -f springapp
# podman rm springapp
# docker login
# docker tag springapiejemplo:1.0 alansastre/springapiejemplo:1.0
# podman push alansastre/springbootapp:1.0

# Desde un servidor:
# docker pull alansastre/springapiejemplo:1.0
# docker run -p 8080:8080 --name springapp -d -t alansastre/springapiejemplo:1.0
# docker rmi alansastre/springapiejemplo:1.0