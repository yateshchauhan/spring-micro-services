package com.rnd.microservice.priceservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("Price-Property-Configuration")
public class ConfigurationBean {

    @Bean(name = "pricePropertyConfiguration")
    public PropertyConfiguration pricePropertyConfiguration(){
        return new PropertyConfiguration();
    }


}
