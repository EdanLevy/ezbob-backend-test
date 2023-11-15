package com.edan.serviceshuffle;


import com.edan.api.Exceptions.PayloadOutOfRange;
import com.edan.api.Model.ShuffleRequestPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class ShuffleService {
    private static final Logger Log = LoggerFactory.getLogger(ShuffleService.class);
    final ServiceLogConfiguration serviceLogCofig;
    private final int minRange = 1;
    private final int maxRange = 1000;

    @Autowired
    public ShuffleService(ServiceLogConfiguration serviceLogCofig) {
        this.serviceLogCofig = serviceLogCofig;
    }

    public int[] shuffle(int max) throws PayloadOutOfRange {
        if (max < minRange || max > maxRange) {
            throw new PayloadOutOfRange();
        }

        logRequest(new ShuffleRequestPayload(max));

        int[] arr = new int[max];
        for (int i = 0; i < max; i++) {
            arr[i] = i + 1;
        }
        for (int i = 0; i < max; i++) {
            int j = (int) (Math.random() * max);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }

    protected void logRequest(ShuffleRequestPayload request) {
        CompletableFuture
                .supplyAsync(() -> {
                    RestTemplate restTemplate = new RestTemplate();
                    return restTemplate.postForObject(serviceLogCofig.getServiceLoggerUrl(), request, ShuffleRequestPayload.class);
                })
                .thenAccept(response -> Log.info("Logged response: " + response))
                .exceptionally(e -> {
                    Log.error("Failed to log request: " + e);
                    return null;
                });
    }
}
