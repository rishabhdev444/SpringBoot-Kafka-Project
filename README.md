# SpringBoot-Kafka-Project 

Kafka Commands - 

zookeeper-server-start.bat ..\..\config\zookeeper.properties              ------------ to start the zookeeper in cmd 

kafka-server-start.bat ..\..\config\server.properties                    --------------- to start kafka broker/server

kafka-topics.bat --create --topic "topic-name" --bootstrap-server localhost:9092 --replication-factor 1 --partitions 3                        ---------- to create a topic with name of "topic-name"

kafka-console-producer.bat --broker-list localhost:9092 --topic "topic-name"                            -----------------to start kafka producer of topic -"topic name"

kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic my-topic --from-beginning        -------- to start the consumer and read the data from producer 



############# kafka Configuration in SpringBoot

spring.kafka.consumer.bootstrap-servers:localhost:9092
spring.kafka.consumer-group-id:myGroup
spring.kafka.consumer.auto-offset-reset:earliest
spring.kafka.consumer.key-deserializer:org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer:org.apache.kafka.common.serialization.StringDeserializer

spring.kafka.producer.bootstrap-servers:localhost:9092
spring.kafka.producer.key-serializer:org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-serializer:org.apache.kafka.common.serialization.StringSerializer
