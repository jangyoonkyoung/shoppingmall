package com.shopping.api;

import java.util.Map;

import com.shopping.service.DeliveryService;
import com.shopping.vo.DeliveryVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryAPIController {
    @Autowired DeliveryService service;
    @PostMapping("/delivery/add")
    public Map<String, Object> insertDelivery(@RequestBody DeliveryVO vo){
        return service.insertDelivery(vo);
    }
}
