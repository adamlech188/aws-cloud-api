package com.demo.aws.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;

@Configuration
@EnableScheduling
public class AWSConfiguration {

	@Bean
	public AmazonSQS createAmazonSQS() {
		return AmazonSQSClientBuilder.defaultClient();
	}
}
