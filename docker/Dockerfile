FROM tomcat:9.0-jdk11

RUN rm -rf /usr/local/tomcat/webapps/*
COPY target/exploded/ /usr/local/tomcat/webapps/ROOT/
