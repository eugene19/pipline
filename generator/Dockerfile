FROM openjdk:11
WORKDIR /
ADD Generator.jar Generator.jar
EXPOSE 8080
CMD while ! curl rabbitmq:15672 -m1 -o/dev/null -s ; do sleep 0.1; done \
  && java -jar Generator.jar 

