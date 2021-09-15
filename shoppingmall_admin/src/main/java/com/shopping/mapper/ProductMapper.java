package com.shopping.mapper;

import java.util.List;

import com.shopping.vo.ProductVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    public void insertProduct(ProductVO vo);
    public List<ProductVO> selectAllList(Integer offset, String keyword, Integer category);
    public void deleteProduct(Integer seq); 
    
}
