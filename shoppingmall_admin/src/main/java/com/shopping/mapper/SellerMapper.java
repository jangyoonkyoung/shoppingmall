package com.shopping.mapper;

import java.util.List;

import com.shopping.vo.SellerInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SellerMapper {
    public void insertSeller(SellerInfoVO vo);
    public Integer selectSellerById(String id);
    public Integer selectSellerByEmail(String email);
    public List<SellerInfoVO> selectSellerList();
    public void sellerDelete(Integer seq);
    public String selectSellerName(Integer seq);
}
