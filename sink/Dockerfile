FROM bitnami/kafka

COPY  ./hdfs-sink/ /opt/sink/
COPY  ./hdfs-sink/lib/ /opt/bitnami/kafka/libs/

#CMD sleep 20 && /opt/bitnami/kafka/bin/connect-standalone.sh /opt/sink/etc/connect-avro-docker.properties /opt/sink/etc/quickstart-hdfs.properties

#CMD echo "hello world!"
#ENTRYPOINT [“/opt/bitnami/kafka/bin/connect-standalone.sh”, “/opt/connector/etc/connect-avro-docker.properties”, “/opt/connector/etc/RabbitMQSourceConnector.properties”]

