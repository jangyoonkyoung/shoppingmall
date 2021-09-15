package com.shopping.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.shopping.mapper.CategoryMapper;
import com.shopping.mapper.DeliveryMapper;
import com.shopping.mapper.ProductMapper;
import com.shopping.mapper.SellerMapper;
import com.shopping.vo.ProductVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired ProductMapper mapper;
    @Autowired CategoryMapper cate_mapper;
    @Autowired DeliveryMapper del_mapper;
    @Autowired SellerMapper sel_mapper;
    public Map<String, Object> insertProduct(ProductVO vo){ 
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        mapper.insertProduct(vo);
        return resultMap;
    }

    public List<ProductVO> selectAllList(Integer offset, String keyword, Integer category){
        if(offset==null)offset=0;
        if(keyword==null){keyword="%%";} else {keyword="%"+keyword+"%";};

        List<ProductVO> list = mapper.selectAllList(offset, keyword, category);
        for(int i=0; i<list.size(); i++) {
            Integer cate_seq = list.get(i).getPi_cate_seq();
            String cate_name = cate_mapper.selectCategoryByName(cate_seq);
            list.get(i).setCategory_name(cate_name);
            Integer di_seq = list.get(i).getPi_di_seq();
            String di_name = del_mapper.selectDeliveryName(di_seq);
            list.get(i).setDelivery_name(di_name);
            Integer si_seq = list.get(i).getPi_si_seq();
            String si_name = sel_mapper.selectSellerName(si_seq);
            list.get(i).setSeller_name(si_name);
        }

        return list;
    }
    public void deleteProduct(Integer seq){
        mapper.deleteProduct(seq);
    }
}
