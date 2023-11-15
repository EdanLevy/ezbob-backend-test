package com.edan.serviceshuffle;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceLogConfiguration {
    private final String serviceLoggerHostName;
    private final int serviceLoggerPort;

    public ServiceLogConfiguration(@Value("${app.service-log.hostname}") String serviceLoggerHostName,
                                   @Value("${app.service-log.port}") int serviceLoggerPort) {
        this.serviceLoggerHostName = serviceLoggerHostName;
        this.serviceLoggerPort = serviceLoggerPort;
    }
    
    public String getServiceLoggerUrl(){
        return "http://" + serviceLoggerHostName + ":" + serviceLoggerPort + "/";
    }
}
