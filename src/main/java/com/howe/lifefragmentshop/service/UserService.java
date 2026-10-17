package com.howe.lifefragmentshop.service;

import com.howe.lifefragmentshop.mapper.UserMapper;
import com.howe.lifefragmentshop.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    //这是一个用户的逻辑层
    //该层要判断创建的用户是否合理，合理就创建用户，不合理就抛出异常
    //然后控制层就是要接住异常
    @Autowired
    UserMapper userMapper;

    @Transactional//一个事务
    public int addUser(User user){//创建用户的方法

        //判断属性值
        //是否不为空
        if(user.getUsername()==null||user.getPassword()==null||user.getNickname()==null)
            throw new RuntimeException("请输入必填参数");

        //查询用户是否存在
        if(userMapper.findByUsername(user.getUsername())!=null)
            throw new RuntimeException("用户已存在！");

        user.setRole("user");//暂时先设置固定值为用户

        //返回一个sql中的改变行数,如果返回0就是没有创建成功，大于0就是创建成功了
        return userMapper.insertUser(user);
    }
}
