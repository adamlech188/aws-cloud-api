package com.demo.aws.scheduler;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.Message;

@Service
public class ReceiveSQSMessageScheduler {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private AmazonSQS amazonSQS; 
	
	@Autowired
	public ReceiveSQSMessageScheduler(AmazonSQS amazonSQS) {
		this.amazonSQS = amazonSQS;
	}


	@Scheduled(fixedRate = 2, timeUnit = TimeUnit.SECONDS)
	public void receiveMessage() {
		String url = amazonSQS.getQueueUrl("EventsFromS3").getQueueUrl();
		
		List<Message> messages = amazonSQS.receiveMessage(url).getMessages();
		//logger.info("Size is: "  + messages.size());
		for (Message message : messages) {
			logger.info("Message received: {}", message.getBody());
			amazonSQS.deleteMessage(url, message.getReceiptHandle());
			
		}
	}
}
