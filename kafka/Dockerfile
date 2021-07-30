FROM bitnami/kafka

COPY  ./connector/ /opt/connector/
COPY  ./connector/lib/ /opt/bitnami/kafka/libs/

CMD sleep 20 && /opt/bitnami/kafka/bin/connect-standalone.sh /opt/connector/etc/connect-avro-docker.properties /opt/connector/etc/RabbitMQSourceConnector.properties

#CMD echo "hello world!"
#ENTRYPOINT [“/opt/bitnami/kafka/bin/connect-standalone.sh”, “/opt/connector/etc/connect-avro-docker.properties”, “/opt/connector/etc/RabbitMQSourceConnector.properties”]

