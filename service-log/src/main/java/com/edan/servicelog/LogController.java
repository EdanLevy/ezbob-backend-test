package com.edan.servicelog;

import com.edan.api.Model.ShuffleRequestPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

    private final LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }
    

    @PostMapping("/")
    public void logRequest(@RequestBody ShuffleRequestPayload request) {
        
        logService.logRequest(request);
    }
}
