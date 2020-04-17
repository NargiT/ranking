FROM tomcat:8.5.51-jdk8-openjdk
MAINTAINER Tigran Tchougourian
ARG WAR_NAME

ENV ZULU_HOME="/usr/lib/jvm/zulu-8-amd64"
ENV OPENJDK_HOME="/usr/local/openjdk-11"

RUN apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv-keys 0xB1998361219BD9C9 && \
    echo 'deb http://repos.azulsystems.com/debian stable main' > /etc/apt/sources.list.d/zulu.list && \
    apt update && \
    apt install -y --no-install-recommends zulu-8

ENV JAVA_HOME="/usr/lib/jvm/zulu-8-amd64"
ENV PATH="/usr/lib/jvm/zulu-8-amd64/bin:/usr/local/tomcat/bin:/usr/local/openjdk-8/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin"

COPY target/${WAR_NAME}.war /usr/local/tomcat/webapps/ranking-service.war
