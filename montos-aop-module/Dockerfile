# 该镜像需要依赖的基础镜像
FROM fabric8/java-alpine-openjdk8-jdk
VOLUME /tmp
VOLUME /log
VOLUME /tmp/uploads/
ADD target/montos-aop-module-1.0.0-RELEASE.jar app.jar

#ADD repeater-stable-bin.tar /root
COPY sandbox-agent.jar /lib/sandbox-agent.jar
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-javaagent:/lib/sandbox-agent.jar","-Dapp.name=aop","-Dapp.env=dev","-jar","/app.jar"]
# 指定维护者名称
MAINTAINER Montos 1367654518@qq.com