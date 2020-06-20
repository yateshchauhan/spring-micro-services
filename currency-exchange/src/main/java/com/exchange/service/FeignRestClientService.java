package com.exchange.service;

import com.service.model.Price;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(name = "price-service", url="http://localhost:8080/price")
@FeignClient(name = "price-service")
@RibbonClient(name = "price-service")
public interface FeignRestClientService {

    @GetMapping(path = "price/expose")
    public Price exposePriceService();
}
