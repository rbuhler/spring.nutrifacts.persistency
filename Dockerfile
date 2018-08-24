# Dockerfile
FROM tomcat:8.0-alpine
#FROM tomcat:9.0.10-jre8-alpine
#FROM tomcat:9.0.11-jre8-alpine

# getting started
RUN clear

VOLUME /tmp

# shell commands
RUN ls

# Tomcat specific
COPY tomcat/tomcat-users.xml conf

ADD target/*.war webapps

RUN java -version