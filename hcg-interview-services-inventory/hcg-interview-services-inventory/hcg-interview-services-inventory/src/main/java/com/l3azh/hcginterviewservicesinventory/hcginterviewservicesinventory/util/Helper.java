package com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class Helper {
    @Bean
    @Primary
    public SimpleDateFormat provideSimpleDateFormat(){
        return new SimpleDateFormat("yyyy-MM-dd");
    }
}
