package com.shopping.mapper;

import com.shopping.vo.SellerInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SellerMapper {
    public void insertSeller(SellerInfoVO vo);
    public Integer selectSellerById(String id);
    public Integer selectSellerByEmail(String email);
}
