package com.shopping.mapper;

import java.util.List;

import com.shopping.vo.ProductImageVO;
import com.shopping.vo.ProductVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    public void insertProduct(ProductVO vo);
    public List<ProductVO> selectAllList(Integer offset, String keyword, Integer category);
    public void deleteProduct(Integer seq); 
    public void insertProductImages(ProductImageVO vo);
    public String selectProdImagePath(String uri);
    public List<ProductVO> selectRecommand();
    public List<ProductVO> selectNotRecommand();
    public void insertRecommand(Integer prod_seq);
    public void deleteRecommand(Integer prod_seq);
}
