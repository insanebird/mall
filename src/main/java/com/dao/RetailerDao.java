package com.dao;

import com.entity.Retailer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RetailerDao {
    @Select("select * from retailer where id=#{id}")
    public Retailer getRetailerById(Integer id);

    @Select("select * from retailer")
    public List<Retailer> getRetailerList();

    @Insert("insert into retailer (name,description,logo,founder,found_time,founder_name) values(#{name},#{description},#{logo},#{founder},#{foundTime},#{founderName})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void addRetailer(Retailer retailer);

    @Select("select * from retailer where name=#{name}")
    public Retailer checkRetailer(String name);

    @Select("select * from retailer where founder=#{id}")
    public Retailer getRetailerByFounder(Integer id);

    @Update("update retailer set status=#{param1} where id=#{param2}")
    public void changeStatusById(Integer statusId, Integer id);

    @Update("update retailer set name=#{name},description=#{description},logo=#{logo} where id=#{id}")
    public void changeRetailerInformation(Retailer retailer);
}