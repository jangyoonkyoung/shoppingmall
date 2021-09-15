package com.shopping.mapper;

import java.util.List;

import com.shopping.vo.CategoryVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {
    public void insertCategory(CategoryVO vo);
    public Integer selectCategoryName(String name);
    public List<CategoryVO> cateListAll();
    public void deleteCategory(Integer seq);
    public String selectCategoryByName(Integer seq);
}
