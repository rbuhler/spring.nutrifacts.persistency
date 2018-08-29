# Dockerfile
FROM openjdk:8-jdk

# Getting started
VOLUME /tmp

# shell commands
RUN ls

# Application
ADD target/*.jar nutrifacts-persistency.jar

# JAVA specifics
CMD java $JAVA_OPTS -jar /nutrifacts-persistency.jar

RUN java -version

# Others
ENTRYPOINT ["java","-agentlib:jdwp=transport=dt_socket,address=8000,server=y,suspend=n","-jar","/nutrifacts-persistency.jar"]