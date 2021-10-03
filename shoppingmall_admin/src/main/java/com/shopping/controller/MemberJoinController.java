package com.shopping.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberJoinController {
    @GetMapping("/join")
    public String getMemberJoin(){
        return "/member/join";
    }
    @GetMapping("/login")
    public String getmemberLogin(){
        return "/member/login";
    }
    @GetMapping("/logout")
    public String memberLogout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
    @GetMapping("/member")
    public String getMemberInfo(){
        return "/member/member";
    }
}
