package com.shopping.api;

import java.util.LinkedHashMap;
import java.util.Map;

import com.shopping.service.DeliveryService;
import com.shopping.vo.DeliveryVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryAPIController {
    @Autowired DeliveryService service;
    @PostMapping("/delivery/add")
    public Map<String, Object> insertDelivery(@RequestBody DeliveryVO vo){
        return service.insertDelivery(vo);
    }
    @GetMapping("/delivery/chk")
    public Map<String, Object> getDeliveryName(@RequestParam String name){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        boolean r = service.isDoplicatedByName(name);
        if(r){
            resultMap.put("message","["+name+"은 이미 존재합니다.");
        }
        else{
            resultMap.put("message","["+name+"은 등록 가능합니다.");
        }
        return resultMap;
    }
}
