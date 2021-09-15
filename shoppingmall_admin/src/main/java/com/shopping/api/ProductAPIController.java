package com.shopping.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.shopping.service.ProductService;
import com.shopping.vo.ProductVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductAPIController {
    @Autowired ProductService service;
    @PostMapping("/product/add")
    public Map<String, Object> postProductAdd(@RequestBody ProductVO vo){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        service.insertProduct(vo);
        resultMap.put("status","success");
        resultMap.put("message","상품이 추가되었습니다.");
        return resultMap;
    }
    @GetMapping("/product/list")
    public Map<String, Object> productList(
        @RequestParam @Nullable String keyword, 
        @RequestParam @Nullable Integer offset, 
        @RequestParam @Nullable Integer category 
    ){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        List<ProductVO> list = service.selectAllList(offset, keyword, category);
        resultMap.put("data", list);
        return resultMap;

    }
    @DeleteMapping("/delete/product")
    public Map<String, Object> deleteProduct(@RequestParam Integer seq){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        service.deleteProduct(seq);
        resultMap.put("message","삭제되었습니다.");
        return resultMap;
        
    }
}
