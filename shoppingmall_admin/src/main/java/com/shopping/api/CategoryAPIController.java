package com.shopping.api;

import java.util.Map;

import com.shopping.service.CategoryService;
import com.shopping.vo.CategoryVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryAPIController {
    @Autowired CategoryService service;
    @PostMapping("/add/category")
    public Map<String, Object> insertCategory(@RequestBody CategoryVO vo){
        return service.insertCategory(vo);
    }
}
