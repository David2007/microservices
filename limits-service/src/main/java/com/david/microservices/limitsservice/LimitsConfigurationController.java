package com.david.microservices.limitsservice;

import com.david.microservices.limitsservice.bean.LimitConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    @Autowired
    private Configuration configuration;

    @GetMapping(path = "/limits")
    public LimitConfiguration retrieveLimitsFromConfigurations(){
        return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
    }

    @GetMapping("/fault-tolerance-example")
    @HystrixCommand(fallbackMethod="fallbackretrieveConfiguration")
    public LimitConfiguration retrieveConfiguration(){
        throw new RuntimeException("not available");
    }
    public LimitConfiguration fallbackretrieveConfiguration(){
        return new LimitConfiguration(9, 999);
    }
}
