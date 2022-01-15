package com.myblog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MainController {
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
        return "index";
    }
}
