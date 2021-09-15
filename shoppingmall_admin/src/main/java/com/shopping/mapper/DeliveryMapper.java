package com.shopping.mapper;

import java.util.List;

import com.shopping.vo.DeliveryVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeliveryMapper {
    public void insertDelivery(DeliveryVO vo);
    public Integer selectDeliveryById(String name);
    public List<DeliveryVO> selectDeliveryAll();
    public void deleteDelivery(Integer seq);
    public String selectDeliveryName(Integer seq);

}
