package com.myblog.restController;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/boardRest")
public class BoardRestController {

    //기동
    @PutMapping
    public String updateBoard() {

        return "";
    }
    //상태확인
    @GetMapping
    public String selectBoard() {
        return "뭔가나오나?";
    }

    //비상정지
    @DeleteMapping
    public String deleteBoard() {
        return "";
    }
    //유저 요청
    @PostMapping
    public String insertBoard(@RequestBody Map<String, Object> param) {
        return "";
    }
}
