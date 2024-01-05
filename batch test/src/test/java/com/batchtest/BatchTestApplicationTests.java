package com.batchtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BatchTestApplicationTests {
    @Autowired
    batch testBatch;
    @Test
    void contextLoads() {
        testBatch.create_file();
    }

}
