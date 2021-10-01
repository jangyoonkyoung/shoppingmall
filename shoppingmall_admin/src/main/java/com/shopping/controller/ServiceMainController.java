package com.shopping.controller;

import com.shopping.mapper.CategoryMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServiceMainController {
    @Autowired CategoryMapper cate_mapper;
    @GetMapping("/")
    public String getMain(Model model){
        model.addAttribute("cateList", cate_mapper.cateListAll());
        return "/admin_main/market_index";
    }
}
