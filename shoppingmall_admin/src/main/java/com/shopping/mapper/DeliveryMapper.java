package com.shopping.mapper;

import com.shopping.vo.DeliveryVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeliveryMapper {
    public void insertDelivery(DeliveryVO vo);
    public Integer selectDeliveryById(String name);
}
