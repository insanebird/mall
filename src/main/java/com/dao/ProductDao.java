package com.dao;

import com.entity.Category;
import com.entity.Order;
import com.entity.SKU;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {
    @Select("select * from sku where sku_status=1")
    public List<SKU> findAll();

    @Select("select count(*) from sku")
    public Integer getCount();

    @Select("select * from sku where sku_status=1 limit #{param1},#{param2}")
    public List<SKU> getPaginationProduct(Integer param1, Integer param2);

    @Select("select * from sku where sku_id=#{id}")
    public SKU getProductById(Integer id);

    @Select("select * from category where category_id=#{cId}")
    public Category getCategoryById(Integer cId);

    @Select("select * from category where level=-1")
    public List<Category> getFirstCategory();

    @Select("select * from category where parent_id=#{id}")
    public List<Category> getCategoryByParentId(Integer id);

    @Select("select * from sku where sku_id=#{id}")
    public SKU getSKUById(Integer id);

    @Select("<script>select * from sku where sku_id in " +
            "<foreach open='(' separator=',' close=')' collection='list' item='item'>" +
            "#{item}</foreach></script>")
    public List<SKU> getSKUsById(@Param("list") List<Integer> list);

    @Insert(value = "insert into indent (price,status,date,user_id,sku_item) values(#{price},#{status},#{date},#{userId},#{skuItem})")
    public void generateOrder(Order order);

    @Insert("insert into sku (sku_name,sku_code,sku_price,sku_image,sku_description,sku_specification,sku_category,sku_bulletin,sku_num,retailer_id,introduce_images) values" +
            "(#{skuName},#{skuCode},#{skuPrice},#{skuImage},#{skuDescription},#{skuSpecification},#{skuCategory},#{skuBulletin},#{skuNum},#{retailerId},#{introduceImages})")
    public void addProduct(SKU sku);

    @Select("select * from sku where retailer_id=#{id}")
    public List<SKU> getSKUByRetailerId(Integer id);

    @Update("update sku set sku_status=#{param1} where sku_id=#{param2}")
    public void changeProductStatus(Integer statusId, Integer id);

    @Update("update sku set sku_status=#{param1} where retailer_id=#{param2}")
    public void disableAllProduct(Integer statusId, Integer retailerId);

    @Select("select * from sku where sku_name like '%${name}%'")
    public List<SKU> getSKUByName(String name);

    @Update("update sku set rate=#{param1} where sku_id=#{param2}")
    public void updateSKURate(Double rate, Integer id);

    @Select("select * from sku where sku_category=#{id}")
    public List<SKU> getSKUByCategory(Integer id);
}