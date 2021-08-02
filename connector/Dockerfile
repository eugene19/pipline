FROM bitnami/kafka

USER root

COPY  ./rabbitmq-source/ /opt/source/
COPY  ./hdfs-sink/ /opt/sink/

CMD while ! curl rabbitmq:15672 -m1 -o/dev/null -s ; do sleep 0.1; done \
  && sleep 3 \
  && /opt/bitnami/kafka/bin/connect-standalone.sh /opt/source/etc/connect-avro-docker.properties /opt/source/etc/RabbitMQSourceConnector.properties /opt/sink/etc/quickstart-hdfs.properties

