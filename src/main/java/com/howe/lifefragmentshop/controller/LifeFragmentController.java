package com.howe.lifefragmentshop.controller;
import com.howe.lifefragmentshop.mapper.LifeFragmentMapper;
import com.howe.lifefragmentshop.pojo.LifeFragment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



@Controller
public class LifeFragmentController {

    @Autowired private LifeFragmentMapper mapper;

    @GetMapping("/Home")
    public String Home(Model model) {

        model.addAttribute("welcome", "欢迎来到我的生命碎片商店");
        List<LifeFragment> fragments = mapper.findAll();
        model.addAttribute("fragments",fragments);
        return "home";
    }
}
