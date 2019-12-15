package com.dao;

import com.entity.RotationChart;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface RotationChartDao {
    @Insert("insert into rotation_chart (images,type) values (#{images},#{type})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void addRotationChart(RotationChart rotationChart);

    @Select("select * from rotation_chart where type=0 order by id desc limit 0,1")
    public RotationChart getHorizontalChart();

    @Select("select * from rotation_chart where type=1 order by id desc limit 0,1")
    public RotationChart getVerticalChart();
}