# Kafka test

### Environment Setup
1. `docker run -e ADV_HOST=<ip> -p 3030:3030 -p 9092:9092 -p 8081-8083:8081-8083 landoop/fast-data-dev`
2. exec inside container
3. `cd /opt/landoop/kafka/bin`
4. `kafka-topics  --create --zookeeper localhost:2181 --partitions 1 --replication-factor 1 --topic mrdctopic`