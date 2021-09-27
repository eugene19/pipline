# Pipline for streaming data from rabbitMQ to HDFS

## For running stream use:
docker-compose up -d

## For stopping stream use:
docker-compose down

## The compose include following apps: 
1) Generator - simple java app to generate test data to RabbitMQ
2) Connector - source and sink connectors to read data from RabbitMQ to Kafka and write data from kafka to HDFS
3) HDFS - container with HDFS
