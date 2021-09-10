package com.shopping.api;

import java.util.LinkedHashMap;
import java.util.Map;

import com.shopping.service.SellerService;
import com.shopping.vo.SellerInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SellerAPIController {
    @Autowired SellerService s_service;
    @PostMapping("/seller/regist")
    public Map<String, Object> postSellerRegist(@RequestBody SellerInfoVO vo){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        
        boolean r = s_service.insertSeller(vo);
        if(r){
            resultMap.put("result","success");
            resultMap.put("message","등록 성공");
        }
        else{
            resultMap.put("result","faild");
            resultMap.put("message","등록 실패");
        }
        return resultMap;
    }
    //아이디 중복 체크 검사
    @GetMapping("/seller/isDuplicated")
    public Map<String, Object> getIsDuplicated(@RequestParam String id){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        if(s_service.isDuplicated(id)){
            resultMap.put("status",true);
            resultMap.put("message","아이디가 중복됩니다.");
        }
        else{
            resultMap.put("status",false);
            resultMap.put("message","가입 가능한 아이디 입니다.");
        }
        return resultMap;
    }
}
