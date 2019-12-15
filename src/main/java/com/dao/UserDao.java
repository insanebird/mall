package com.dao;

import com.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    @Insert("insert into user (username,password) values(#{username},#{password})")
    @Options(keyProperty = "id", useGeneratedKeys = true)
    public void addUser(User user);

    @Select("select * from user where username=#{username} and password=#{password}")
    public User signIn(User user);

    @Select("select * from user where username=#{username}")
    public User check(String username);

    @Update("update user set identity=1 where id=#{id}")
    public void toBeVIP(Integer id);

    @Select("select * from user where id=#{id}")
    public User getUserById(Integer id);

    @Update("update user set is_retailer=1 where id=#{id}")
    public void toBeRetailer(Integer id);

    @Select("select * from user")
    public List<User> findAll();

    @Select("select * from user where identity=1")
    public List<User> getVIPList();

    @Update("update user set is_speak=#{status} where id=#{id}")
    public void changeStatus(Integer status, Integer id);

    @Select("select * from user where id=#{id} and password=#{password}")
    public User checkPassword(User user);

    @Update("update user set password=#{password} where id=#{id}")
    public void changePassword(User user);

    @Update("update user set name=#{name},image=#{image} where id=#{id}")
    public void updateUserInformation(User user);
}