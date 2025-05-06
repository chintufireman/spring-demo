#### Configuring kafka

1. mention bootstrap server
2. declare group name `spring.kafka.consumer.group-id: stock` this is important because lets say there are multiple consumers consuming their messages from single topic then this `stock` groupid plays very imp role.

3. example: we have 2 consumers here stock and email service which are consuming messages from single topic so if there are multiple consumers for single topic then we have to assign group id. we dont have to assign single or same group for both service.

4. configure offset `spring.kafka.consumer.auto-offset-reset: earliest` lets say we havent provided initial offset then kafka will provide initial offset earliest.

5. configure deserializer for kafka consumer key `spring.kafka.consumer.key-deserializer: org.apache.kafka.common.serialization.StringDeserializer`
6. configure deserializer for value
`spring.kafka.consumer.value-deserializer: org.springframework.kafka.support.serializer.JsonDeserializer`

7. You have to mention `spring.kafka.consumer.properties.spring.json.trusted.packages=*` this property is imp because whatever property u mention will be applicable for json serializer and deserializer

8. configure topic name `spring.kafka.topic.name=order_topic`

#### creating kafka consumer service
1. u create a package kafka and inside that create a class `OrderConsumer`.

2. after this create a consume method annotate it with `@KafkaListener` and inside that mention topic name from where we have to consume message and group-id for this consumer to listen from.

