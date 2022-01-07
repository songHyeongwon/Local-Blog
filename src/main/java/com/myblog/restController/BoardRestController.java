package com.myblog.restController;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/boardRest")
public class BoardRestController {

    //기동
    @PutMapping
    public String moveElevator() {

        return "";
    }
    //상태확인
    @GetMapping
    public String getElevator() {
        return "";
    }

    //비상정지
    @DeleteMapping
    public String stopElevator() {
        return "";
    }
    //유저 요청
    @PostMapping
    public String savePeople(@RequestBody Map<String, Object> param) {
        return "";
    }
}
