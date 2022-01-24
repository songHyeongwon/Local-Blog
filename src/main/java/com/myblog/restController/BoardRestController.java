package com.myblog.restController;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/Api/boardRest")
//, method={RequestMethod.GET, RequestMethod.POST,RequestMethod.DELETE, RequestMethod.PUT}
public class BoardRestController {

    //기동
    @PutMapping
    public String updateBoard() {

        return "";
    }
    //상태확인
    @GetMapping
    public String selectBoard() {
        System.out.println("selectBoard");
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
        System.out.println("insertBoard");
        String title = (String)param.get("title");
        String menuId = (String)param.get("menuId");
        String text = (String)param.get("text");

        System.out.println("title = " + title);
        System.out.println("menuId = " + menuId);
        System.out.println("text = " + text);

        return "오우 반환되었습니다.";
    }
}
