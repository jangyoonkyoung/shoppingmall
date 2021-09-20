package com.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminMainController {
    @GetMapping("/admin")
    public String getAdminMain(){
    return "admin_main/index";
    }
}
