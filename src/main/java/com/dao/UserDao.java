package com.dao;

import com.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    @Insert("insert into user (username,password) values(#{username},#{password})")
    @Options(keyProperty = "id", useGeneratedKeys = true)
    public void addUser(User user);

    @Select("select * from user where username=#{username} and password=#{password}")
    public User signIn(User user);

    @Select("select * from user where username=#{username}")
    public User check(String username);
}