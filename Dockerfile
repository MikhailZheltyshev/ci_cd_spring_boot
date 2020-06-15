FROM adoptopenjdk/openjdk11:alpine-slim
VOLUME /tmp
COPY build/libs/ci_cd_spring_boot-*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]