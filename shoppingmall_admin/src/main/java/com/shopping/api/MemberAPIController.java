package com.shopping.api;

import java.util.LinkedHashMap;
import java.util.Map;

import com.shopping.service.MemberService;
import com.shopping.vo.MemberInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberAPIController {
    @Autowired MemberService service;
    @PostMapping("/member/join")
    public Map<String, Object> memberjoin(@RequestBody MemberInfoVO vo){
        return service.insertmember(vo);
    }
    @GetMapping("/member/id_check")
    public Map<String, Object> getMemberIdCheck(@RequestParam String id) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        if(service.isDuplicatedId(id) == true) {
            resultMap.put("status", false);
            resultMap.put("message", "[ "+id+" ] 는 이미 사용중인 아이디입니다.");
            return resultMap;
        }
        resultMap.put("status", true);
        resultMap.put("message", "[ "+id+" ] 는 사용하실 수 있습니다.");

        return resultMap;
    } 
    @GetMapping("/member/email_check")
    public Map<String, Object> getMemberEmailCheck(@RequestParam String email) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        if(service.isDuplicatedEmail(email) == true) {
            resultMap.put("status", false);
            resultMap.put("message","["+email+"] 는 존재하는 이메일 입니다.");
            return resultMap;
        }
        resultMap.put("status", true);
        resultMap.put("message","["+email+"] 는 사용할 수 있습니다.");

        return resultMap;
    }
}
