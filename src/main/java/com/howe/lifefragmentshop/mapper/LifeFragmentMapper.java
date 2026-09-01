package com.howe.lifefragmentshop.mapper;

import com.howe.lifefragmentshop.pojo.LifeFragment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LifeFragmentMapper {

    @Select("select * from life_fragment")
    List<LifeFragment> findAll();//查询所有生命碎片
}
