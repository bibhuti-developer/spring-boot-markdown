# view docker version
# --------------
# C\:> docker -v

# view docker images
# -------------
# C\:> docker images

# build docker image 
# -f -> docker file
# -t -> tag name
# ------------------
# C\:> docker build -f Dockerfile -t docker-image-name .

# run docker image
# -p -> push and map to port
# ----------------
# C\:> docker run -p 5555:5555 docker-image-name 

FROM openjdk:8
ADD target/project.jar project.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "project.jar"]