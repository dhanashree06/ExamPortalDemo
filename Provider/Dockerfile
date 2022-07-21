FROM openjdk:8
ADD target/docker-um-provider.jar docker-um-provider.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","docker-um-provider.jar"]