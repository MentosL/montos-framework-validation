FROM openjdk:8-jdk-alpine
ENV TZ=Asia/Shanghai
RUN set -eux; \
    ln -snf /usr/share/zoneinfo/$TZ /etc/localtime; \
    echo $TZ > /etc/timezone
VOLUME /tmp
COPY /target/montos-scheduled-module-1.0.0-RELEASE.jar app.jar
COPY arex-agent-0.2.0.jar /usr/local/arex-agent-0.2.0.jar
COPY arex-agent-bootstrap-0.2.0.jar  /usr/local/arex-agent-bootstrap-0.2.0.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","-javaagent:/usr/local/arex-agent-0.2.0.jar","-Darex.service.name=schedule-service","-Darex.storage.service.host=192.168.0.103:8093","/app.jar"]
