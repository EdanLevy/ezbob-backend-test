package com.edan.servicelog;

import com.edan.api.Model.ShuffleRequestPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LogService {
    
    private static final Logger Log = LoggerFactory.getLogger(LogService.class);
    
    public void logRequest(ShuffleRequestPayload request){
        Log.info("Request received: " + request.toString());
    }
}
