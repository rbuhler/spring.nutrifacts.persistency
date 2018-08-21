# Dockerfile
FROM tomcat:8.0-alpine

VOLUME /tmp

ADD target/*.war /usr/local/tomcat/webapps/

ENTRYPOINT ["catalina.sh", "jpda", "run"]