package com.shopping.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.shopping.service.SellerService;
import com.shopping.vo.SellerInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SellerAPIController {
    @Autowired SellerService s_service;
    //seller 등록하기
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
    @GetMapping("/seller/isDuplicatedId")
    public Map<String, Object> getIsDuplicatedId(@RequestParam String id){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        if(s_service.isDuplicatedId(id)){
            resultMap.put("status",true);
            resultMap.put("message","아이디가 중복됩니다.");
        }
        else{
            resultMap.put("status",false);
            resultMap.put("message","가입 가능한 아이디 입니다.");
        }
        return resultMap;
    }
    //이메일 중복 체크 검사
    @GetMapping("/seller/isDuplicatedEmail")
    public Map<String, Object> getIsDuplicatedEmail(@RequestParam String email){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        if(s_service.isDuplicatedEmail(email)){
            resultMap.put("status",true);
            resultMap.put("message","이메일이 중복됩니다.");
        }
        else{
            resultMap.put("status",false);
            resultMap.put("message","가입 가능한 이메일 입니다.");
        }
        return resultMap;
    }
    @GetMapping("/seller/list")
    public Map<String, Object> selectSellerList (){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        List<SellerInfoVO> list = s_service.selectSellerList();
        resultMap.put("data",list);
        return resultMap;
    }
    @DeleteMapping("/seller/delete")
    public Map<String, Object> sellerDelete(@RequestParam Integer seq){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        s_service.sellerDelete(seq);
        resultMap.put("message", "삭제되었습니다.");
        return resultMap;
    }
}
