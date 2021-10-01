# Pipeline for streaming data from rabbitMQ to HDFS

## For running stream use:
docker-compose up -d

## For stopping stream use:
docker-compose down

## The compose include following apps: 
1) Containers with RabbitMQ and Kafka
2) Pipeline - container with stream from RabbitMQ to Kafka and from Kafka to HDFS
3) HDFS - container with HDFS
