package learning.microservice.stockservice.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import learning.microservice.basedomains.dto.OrderEvent;

@Service
public class OrderConsumer {

	private static final Logger logger = LoggerFactory.getLogger(OrderConsumer.class);
	
	@KafkaListener(topics = "${spring.kafka.topic.name}"
			, groupId = "${spring.kafka.consumer.group-id}")
	private void consume(OrderEvent orderEvent) {
		logger
		.info(String.format("Order event received in email service => %s", orderEvent.toString()));
		
		//send email to customer
		
	}
}
