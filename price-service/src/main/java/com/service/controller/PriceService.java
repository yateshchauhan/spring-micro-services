package com.service.controller;

import com.price.model.Price;
import com.rnd.microservice.priceservice.PropertyConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("price")
public class PriceService {

    private static final Logger log = LoggerFactory.getLogger(PriceService.class);

    @Autowired(required = true)
    private PropertyConfiguration pricePropertyConfiguration;
    @Autowired
    private Environment environment;
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }

    @GetMapping(path = "/expose")
    public Price exposePrices(){
        log.info("expose service invoked");
        String port = environment.getProperty("local.server.port");
        return new Price(Integer.valueOf(port),pricePropertyConfiguration.getMin());

    }

    public void setPricePropertyConfiguration(PropertyConfiguration pricePropertyConfiguration) {
        this.pricePropertyConfiguration = pricePropertyConfiguration;
    }
}
