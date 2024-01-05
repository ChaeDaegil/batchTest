package com.batchtest.service;

import org.springframework.batch.core.ExitStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CustomTruncateService {
    @Autowired
    public JdbcTemplate jdbcTemplate;
    public ExitStatus execute(){
       jdbcTemplate.execute("TRUNCATE TABLE `person`");
        return ExitStatus.COMPLETED;
    }
}
