package com.batchtest;

import com.batchtest.dto.CsvDTO;
import com.batchtest.mapper.RestaurantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Component
@EnableScheduling
public class batch {
    @Autowired
    RestaurantMapper restaurantMapper;
    @Scheduled(cron = "0 40 5 * * *") // 매일 05:40에 실행하는 cron 표현식
//    @Scheduled(cron = "*/10 * * * * *")
    public void performTask() {
        create_file();
    }
    public void create_file(){
        System.out.println("작업 실행 시간: " + DateTimeFormatter.ofPattern("yyyyMMdd_HHmm").format(LocalDateTime.now()));
        List<CsvDTO> csvDTOList = restaurantMapper.select_restaurant();

        if(csvDTOList.isEmpty())return;
        String filePath = DateTimeFormatter.ofPattern("yyyyMMdd_HHmm").format(LocalDateTime.now())+"_통계.csv";

        File file = null;
        BufferedWriter bw = null;
        String NEWLINE = System.lineSeparator(); // 줄바꿈(\n)

        try {
            file = new File(filePath);
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_8));
            bw.write("\uFEFF");
            bw.write("시/군/구,총조회수");
            bw.write(NEWLINE);

            for (CsvDTO csvDTO : csvDTOList){
                System.out.println(csvDTO);
                bw.write(csvDTO.getGnn()+","+csvDTO.getAllViewCount());
                bw.write("\n");
            }
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        restaurantMapper.truncate_restaurant();
    }

}
