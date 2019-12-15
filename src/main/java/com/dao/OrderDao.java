package com.dao;

import com.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {
    @Insert("insert into indent (price,status,date,user_id,sku_item,retailer_id) values(#{price},#{status},#{date},#{userId},#{skuItem},#{retailerId})")
    public void generateOrder(Order order);

    @Select("select * from indent where user_id=#{id}")
    public List<Order> getOrderListByUserId(Integer id);

    @Select("select * from indent where retailer_id=#{id}")
    public List<Order> getOrderByRetailerId(Integer id);

    @Select("select * from indent where date(date)=curdate() and retailer_id=#{id}")
    public List<Order> getTodayOrder(Integer id);

    @Update("update sku set sku_num=sku_num-#{param1} where sku_id=#{param2}")
    public void decreaseProduct(Integer num, Integer id);

    @Update("update sku set sale_num=sale_num+#{param1} where sku_id=#{param2}")
    public void increaseSaleNum(Integer num, Integer id);

    @Select("select * from indent where date_format(date,'%Y-%m')=date_format(curdate(),'%Y-%m') and retailer_id=#{id}")
    public List<Order> getOrderByMonthAndRetailerId(Integer id);
}