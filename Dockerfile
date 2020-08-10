FROM openjdk:14
VOLUME /tmp
ADD build/libs/ChatApi-0.0.1.jar ChatApi-0.0.1.jar
RUN bash -c 'touch /ChatApi-0.0.1.jar'
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/ChatApi-0.0.1.jar"]