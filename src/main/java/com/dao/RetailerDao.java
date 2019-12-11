package com.dao;

import com.entity.Retailer;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface RetailerDao {
    @Select("select * from retailer where id=#{id}")
    public Retailer getRetailerById(Integer id);
}
