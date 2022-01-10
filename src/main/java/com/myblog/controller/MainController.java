package com.myblog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MainController {
    @GetMapping({"/", "index"})
    public String mainPage(Map<String, Object> model) {
        System.out.println("mainPage");
        return "index";
    }

//    @GetMapping({"login"})
//    public String loginPage(Map<String, Object> model) {
//        return "login";
//    }

//    @GetMapping({"logout"})
//    public String logoutPage(HttpServletRequest request, HttpServletResponse response , Map<String, Object> model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if(authentication != null){
//            new SecurityContextLogoutHandler().logout(request,response,authentication);
//        }
//        return "index";
//    }
}
