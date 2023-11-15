package com.edan.serviceshuffle;


import com.edan.api.Exceptions.PayloadOutOfRange;
import com.edan.api.Model.ShuffleRequestPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ShuffleController {
    
    final ShuffleService shuffleService;

   

    @Autowired
    public ShuffleController(ShuffleService shuffleService) {
        this.shuffleService = shuffleService;
    }

    @PostMapping("/")
    public int[] shuffle(@RequestBody ShuffleRequestPayload max) throws PayloadOutOfRange {
        return shuffleService.shuffle(max.number());
    }

   

}
