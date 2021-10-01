package com.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberJoinController {
    @GetMapping("/member")
    public String getMember(){
        return "/member/join";
    }
}
