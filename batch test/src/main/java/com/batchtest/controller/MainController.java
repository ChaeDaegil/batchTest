package com.batchtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//@RestController
public class MainController {
    @GetMapping("/main")
    public void get_Main(){
        System.out.println("get_Main");
    }
}
