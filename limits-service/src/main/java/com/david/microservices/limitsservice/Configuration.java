package com.david.microservices.limitsservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//step 1: this enable spring to manage this
@Component
//step 2: specify the prefix
@ConfigurationProperties("limits-service")
public class Configuration {
    // step 3: create the fields
    private int minimum;
    private int maximum;

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }
}
