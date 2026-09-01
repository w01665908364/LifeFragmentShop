package com.howe.lifefragmentshop.service;

import com.howe.lifefragmentshop.mapper.LifeFragmentMapper;
import com.howe.lifefragmentshop.pojo.LifeFragment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LifeFragmentService {

    @Autowired private LifeFragmentMapper mapper;

    public List<LifeFragment> getAllFragments(){

        List<LifeFragment> LifeFragments = mapper.findAll();
        return LifeFragments;
    }

}
