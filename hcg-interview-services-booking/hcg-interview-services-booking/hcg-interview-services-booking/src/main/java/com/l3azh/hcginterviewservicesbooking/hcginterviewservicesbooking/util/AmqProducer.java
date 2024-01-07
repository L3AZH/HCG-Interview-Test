package com.l3azh.hcginterviewservicesbooking.hcginterviewservicesbooking.util;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AmqProducer {
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    public Gson gson;

    public void sendMessage(String queueName, final String message) {
        log.info(message);
        jmsTemplate.send(queueName, session -> session.createTextMessage(message));
    }
}
