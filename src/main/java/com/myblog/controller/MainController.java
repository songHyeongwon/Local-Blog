package com.myblog.controller;

import com.myblog.been.Board;
import com.myblog.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MainController {
    @Autowired
    BoardRepository boardRepository;

    @GetMapping({"/", "index"})
    public String mainPage(Map<String, Object> model, @RequestParam Map<String, String> param) {

        //메인 페이지 처리
        String mainPage = param.get("mainPage");
        if (mainPage == null) {
            mainPage = "list";
        }
        mainPage = "/blogDiv/" + mainPage.toLowerCase() + ".html";
        model.put("mainPage", mainPage);
        System.out.println("mainPage = " + mainPage);


        List<Board> boardList = boardRepository.findAll();
        for(int i = 0; i < boardList.size(); i++) {
            System.out.println(boardList.get(i).toString());
        }

        return "index";
    }

    @GetMapping("/admin/h2-console")
    public String adminPage(Map<String, Object> model, @RequestParam Map<String, String> param) {

        return "h2-console";
    }
}
