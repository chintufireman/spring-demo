package learning.microservice.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import learning.microservice.basedomains.dto.OrderEvent;

@Service
public class OrderProducer {

	static final private Logger logger= LoggerFactory.getLogger(OrderProducer.class);
	
	private NewTopic topic;
	
	private KafkaTemplate<String, OrderEvent> kafkaTemplate;

	public OrderProducer(NewTopic topic, KafkaTemplate<String, OrderEvent> kafkaTemplate) {
		super();
		this.topic = topic;
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(OrderEvent orderEvent) {
		logger.info(String.format("Order event = %s", orderEvent.toString()));
	
		//create message
		Message<OrderEvent> msg = MessageBuilder
				.withPayload(orderEvent)
				.setHeader(KafkaHeaders.TOPIC, topic.name())
				.build();
		
		kafkaTemplate.send(msg);
	}
	
}
