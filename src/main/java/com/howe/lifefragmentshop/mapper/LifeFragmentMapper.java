package com.howe.lifefragmentshop.mapper;

import com.howe.lifefragmentshop.pojo.LifeFragment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LifeFragmentMapper {

    //查询所有生命碎片
    @Select("select * from life_fragment")
    List<LifeFragment> findAll();

    //查询一条生命碎片，用id
    //sql语句用变量的时候注意用#{}
    @Select("select * from life_fragment where id = #{fragmentId}")
    LifeFragment selectById(int fragmentId);

}
