package com.l3azh.hcginterviewservicesbooking.hcginterviewservicesbooking.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateConfig {
    @Bean
    @Primary
    public RestTemplate provideRestTemplate(){
        return new RestTemplate();
    }
}
