package com.howe.lifefragmentshop.mapper;

import com.howe.lifefragmentshop.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    //用户名查用户信息
    @Select("SELECT * FROM tb_user WHERE username = #{username}")
    User findByUsername(String username);

    //创建新用户
    @Insert("insert into tb_user(username, password, nickname, avatar, role) "
    + "values (#{username},#{password},#{nickname},#{avatar},#{role})")
    int insertUser(User user);

}
