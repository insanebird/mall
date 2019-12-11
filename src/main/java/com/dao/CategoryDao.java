package com.dao;

import com.entity.Category;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao {
    @Select("select * from category where category_id=#{id}")
    public Category getCategoryById(Integer id);

    @Select("select * from category")
    public List<Category> findAllCategory();

    @Select("select * from category where parent_id=#{id}")
    public List<Category> findNestedCategory(Integer id);

    @Select("select * from category where level=0")
    public List<Category> findTopLevelCategory();
}
