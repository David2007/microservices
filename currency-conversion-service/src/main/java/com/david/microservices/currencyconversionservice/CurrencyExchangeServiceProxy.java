package com.david.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// version 1: hard code the url of the CES
//@FeignClient(name="currency-exchange-service", url="http://localhost:8000")
// version 2: dynamically get the urls of the CES instance through Eureka
//the name here is exactly the same as in the Eureka naming server
@RibbonClient(name = "currency-exchange-service")
//@FeignClient(name="currency-exchange-service")

// version 3: use the api gateway as the proxy
// instead of directly talk to the CES, talk to the netflix-zuul-api-gateway-server, which serves as a proxy
@FeignClient(name="netflix-zuul-api-gateway-server")
public interface CurrencyExchangeServiceProxy {
    // take the method sig. from currency exchange controller
   // @GetMapping("/currency-exchange/from/{from}/to/{to}")
    //when use the zuul, has also to include the CES application name
    @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversionBean retrieveExchangeValue
    (@PathVariable("from") String from, @PathVariable("to") String to);
}
