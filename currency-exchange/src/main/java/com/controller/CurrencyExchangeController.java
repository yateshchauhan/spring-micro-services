package com.controller;

import com.exchange.service.FeignRestClientService;
import com.service.model.Price;
import com.service.model.ExchangeModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@RestController
@RequestMapping(path = "currency")
public class CurrencyExchangeController {

    private Logger log = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @Autowired
    private Environment environment;
    @Autowired
    private FeignRestClientService feignRestClientService;

    @GetMapping(path = "exchange/from/{from}/to/{to}")
    public ExchangeModel currrencyExchange(@PathVariable("from") String from, @PathVariable("to") String to){

        log.info("currency exchange service invoked");
        ExchangeModel model = new ExchangeModel();
        model.setFrom(from);
        model.setTo(to);
        model.setConvertorRatio(new BigDecimal(65));
        model.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        callFeignPriceService(model);
        return model;
    }

    public void callFeignPriceService(ExchangeModel exchangeModel){

        Price price = feignRestClientService.exposePriceService();
        log.info("Returned Price object:{}",price);
        exchangeModel.setConvertorRatio(new BigDecimal(10));
        exchangeModel.setPort(price.getMax());

    }

    public void callPriceService(ExchangeModel exchangeModel){
        String url = "http://localhost:8080/price/expose";
        ResponseEntity<Price> responseEntity = new RestTemplate().getForEntity(url, Price.class);
        if(responseEntity != null){
            Price price = responseEntity.getBody();
            exchangeModel.setConvertorRatio(new BigDecimal(price.getMax()));
        }

    }
}
