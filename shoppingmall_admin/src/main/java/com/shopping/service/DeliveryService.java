package com.shopping.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.shopping.mapper.DeliveryMapper;
import com.shopping.vo.DeliveryVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
    @Autowired DeliveryMapper mapper;
    public Map<String, Object> insertDelivery(DeliveryVO vo){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        boolean doplicated =isDoplicatedByName(vo.getDi_name());
        if(doplicated){
            resultMap.put("status", false);
            resultMap.put("message", "이미 등록된 배송업체가 존재합니다.");
            return resultMap;
        }
        mapper.insertDelivery(vo);
        resultMap.put("status", true);
        resultMap.put("message", "배달업체 등록이 완료되었습니다.");
        
        return resultMap;
        
    }
    public boolean isDoplicatedByName(String name){
        return mapper.selectDeliveryById(name) > 0;
    }
    public List<DeliveryVO> selectDeliveryAll(){
        return mapper.selectDeliveryAll();
    }
    public void deleteDelivery(Integer seq){
        mapper.deleteDelivery(seq);
    }

}
