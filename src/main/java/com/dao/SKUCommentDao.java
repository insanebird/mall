package com.dao;

import com.entity.SKUComment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SKUCommentDao {
    @Insert("insert into sku_comment (content,date,user_id,sku_id,rate) values (#{content},#{date},#{userId},#{skuId},#{rate})")
    public void addComment(SKUComment comment);

    @Select("select * from sku_comment where sku_id=#{id}")
    public List<SKUComment> getSKUCommentBySKUId(Integer id);

    @Select("select sum(rate) from sku_comment where sku_id=#{id}")
    public Double getRateSumBySKUId(Integer id);
}