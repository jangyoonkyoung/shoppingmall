package com.shopping.service;

import java.util.LinkedHashMap;
import java.util.Map;

import com.shopping.mapper.CategoryMapper;
import com.shopping.vo.CategoryVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired CategoryMapper mapper;
    public Map<String, Object> insertCategory(CategoryVO vo){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        //중복값 확인. 확인만 하고 내보내주는게 없으니 service에서만 하자.
        boolean duplicated = isbuplicatedName(vo.getCate_name());
        if(duplicated){
            resultMap.put("status", false);
            resultMap.put("message", "이미 등록된 카테고리가 존재합니다.");
            return resultMap;
        }
        mapper.insertCategory(vo);

        resultMap.put("status", true);
        resultMap.put("message", "카테고리 등록이 완료되었습니다.");

        return resultMap;
    }
    public boolean isbuplicatedName (String name){
        return mapper.selectCategoryName(name) > 0;
    }
    
    
}
