package com.myblog.restController;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/Api/menuRest")
public class MenuRestController {

    //기동
    @PutMapping
    public String updateMenu() {

        return "";
    }
    //상태확인
    @GetMapping
    public String selectMenu() {
        return "";
    }

    //비상정지
    @DeleteMapping
    public String deleteMenu() {
        return "";
    }
    //유저 요청
    @PostMapping
    public String insertMenu(@RequestBody Map<String, Object> param) {
        return "";
    }
}
