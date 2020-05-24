package com.service.controller;

import com.price.model.Price;
import com.rnd.microservice.priceservice.PropertyConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("price")
public class PriceService {

    private static final Logger log = LoggerFactory.getLogger(PriceService.class);

    @Autowired(required = true)
    private PropertyConfiguration pricePropertyConfiguration;

    @GetMapping(path = "/expose")
    public Price exposePrices(){
        log.info("expose service invoked");
        return new Price(pricePropertyConfiguration.getMax(),pricePropertyConfiguration.getMin());

    }

    public void setPricePropertyConfiguration(PropertyConfiguration pricePropertyConfiguration) {
        this.pricePropertyConfiguration = pricePropertyConfiguration;
    }
}
