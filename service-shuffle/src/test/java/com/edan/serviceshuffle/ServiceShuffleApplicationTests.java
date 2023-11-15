package com.edan.serviceshuffle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("local")
@SpringBootTest
class ServiceShuffleApplicationTests {

    @Autowired
    ShuffleController shuffleController;
    @Test
    void contextLoads() {
    }

}
