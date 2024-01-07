package com.l3azh.hcginterviewservicesbooking.hcginterviewservicesbooking.util;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Helper {

    @Bean
    @Primary
    public Gson provideGson(){
        return new Gson();
    }
}
