package com.shopping.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.shopping.service.CategoryService;
import com.shopping.vo.CategoryVO;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryAPIController {
    @Autowired CategoryService service;
    @PostMapping("/add/category")
    public Map<String, Object> insertCategory(@RequestBody CategoryVO vo){
        return service.insertCategory(vo);
    }
    @GetMapping("/category/all")
    public Map<String, Object> cateListAll(){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        //service에서 가공한 데이터 리스트로 가져오기.
        List<CategoryVO> list = service.cateListAll();
        resultMap.put("list", list);
        return resultMap;
    }
    
    @DeleteMapping("/category/delete")
    public Map<String, Object> deleteCategory(@RequestParam Integer seq){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        service.deleteCategory(seq);
        resultMap.put("message", "삭제되었습니다.");
        return resultMap;
    }
}
