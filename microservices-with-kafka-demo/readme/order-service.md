### Configuring kafka producer for order service
1. first add bootstrap server on which host and port it is running. `spring.kafka.producer.bootstrapservers=localhost:9092`

2. whenever we send event it is sent in Key-value pair and so for that we have to configure serializer classes for that key-value pair. for key `spring.kafka.producer.key-serializer:org.apache.kafka.common.serialization.StringSerializer` for value `spring.kafka.producer.value-serializer: org.springframework.kafka.support.serializer.JsonSerializer` because apache kafka does not have support for json library for serialization thats why we use springframework package.

3. mention kafka topic name

### for importing base-domain in our service
1. I created jar of base-domains.
2. i created in our order-service a lib folder and pasted there jar of base-domains.
3. after that inside our pom.xml i added that jar as a dependancy and updated the project and we were successfully able to use that jar.

### Java configuration for kafka

1. create config package and create class `KafkaTopicConfig` class
2. inside that create new Bean for creating topic and also take name of topic from order.properties file.

### creating kafka producer service for order service
1. create package kafka inside that create new class `OrderProducer` 
and annotate with `@Service` 

2. create kafkatemplate and topic and inject these using constructor injection.

3. after this create sendMessage() method.

4. inside the sendMessage() first create Message using MessageBuilder withPayload as orderEvent and setheader for kafkatopicheader as topic name.

5. using kafkatemplate.send(msg) send ur message.

### create rest apis
1. create placeOrder 
2. get the order details and create new order event set status, message and order object. 
3. send it to kafka producer.


