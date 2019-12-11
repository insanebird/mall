package com.dao;

import com.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {
    @Insert("insert into indent (price,status,date,user_id,sku_item,retailer_id) values(#{price},#{status},#{date},#{userId},#{skuItem},#{retailerId})")
    public void generateOrder(Order order);

    @Select("select * from indent where user_id=#{id}")
    public List<Order> getOrderListByUserId(Integer id);
}
