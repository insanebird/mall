package com.dao;

import com.entity.Category;
import org.apache.ibatis.annotations.Insert;
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

    @Select("select * from category where category_id=#{id}")
    public Category getLastCategory(Integer id);

    @Insert("insert into category (category_name,level,parent_id) values(#{categoryName},#{level},#{parentId})")
    public void addCategory(Category category);

    @Select("select * from category where level=#{level}")
    public List<Category> getCategoryByLevel(Integer level);
}