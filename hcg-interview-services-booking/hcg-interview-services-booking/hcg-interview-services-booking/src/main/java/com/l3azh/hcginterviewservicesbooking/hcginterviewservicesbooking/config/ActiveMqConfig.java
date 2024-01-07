package com.l3azh.hcginterviewservicesbooking.hcginterviewservicesbooking.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@Profile(value = "local")
public class ActiveMqConfig {
    private final Environment environment;

    @Autowired
    public ActiveMqConfig(Environment environment){
        this.environment = environment;
    }

    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(environment.getProperty("spring.activemq.broker-url"));
        connectionFactory.setUserName(environment.getProperty("spring.activemq.user"));
        connectionFactory.setPassword(environment.getProperty("spring.activemq.password"));

        return connectionFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());

        return template;
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setConcurrency("3-10");
        // true: using jms topic, false: using jms queue
        factory.setPubSubDomain(false);

        return factory;
    }
}
