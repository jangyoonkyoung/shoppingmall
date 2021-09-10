package com.shopping.mapper;

import com.shopping.vo.CategoryVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {
    public void insertCategory(CategoryVO vo);
    public Integer selectCategoryName(String name);
}
