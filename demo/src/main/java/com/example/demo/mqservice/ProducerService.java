package com.example.demo.mqservice;


	import com.fasterxml.jackson.core.JsonProcessingException;
	import com.fasterxml.jackson.databind.ObjectMapper;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.beans.factory.annotation.Value;
	import org.springframework.jms.core.JmsTemplate;
	import org.springframework.stereotype.Component;
	import org.springframework.stereotype.Service;

	import javax.jms.TextMessage;
	import java.util.Date;

	@Component
	public class ProducerService {

	   

	    @Autowired
	    JmsTemplate jmsTemplate;

	    public void sendToQueue( String queue ,String mess) throws JsonProcessingException {
	        try {
	           
	            jmsTemplate.send(queue, messageCreator -> {
	                TextMessage message = messageCreator.createTextMessage();
	                message.setText(mess);
	                return message;
	            });
	        }
	        catch (Exception ex) {
	            System.out.println("ERROR in sending message to queue");
	        }
	    }

	    public void sendToTopic(String topic , String mess) throws JsonProcessingException {
	        try {
	           
	  	            jmsTemplate.send(topic, messageCreator -> {
	                TextMessage message = messageCreator.createTextMessage();
	                message.setText(mess);
	                return message;
	            });
	        }
	        catch (Exception ex) {
	            System.out.println("ERROR in sending message to queue");
	        }
	    }

	}

