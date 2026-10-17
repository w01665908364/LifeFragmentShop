package com.howe.lifefragmentshop.controller;

import com.howe.lifefragmentshop.pojo.LifeFragment;
import com.howe.lifefragmentshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;
    //订单控制层，接收到前端发来的商品id

    @GetMapping("/buy")
    public String buy(@RequestParam int fragmentId) {//获取购买的商品id
        try{


            int flag = orderService.addOrder(fragmentId);//调用service的方法，创建订单,返回更改行数
            //提示弹窗，刷新页面
            if(flag>0){
                return "redirect:/Home?buySuccess=true";
            }else {
                return "redirect:/Home?buyError=购买失败";
            }


        } catch (RuntimeException e) {
            // 接住 Service 抛出的异常（商品不存在、已下架、库存不足等）
            String msg = URLEncoder.encode(e.getMessage(), StandardCharsets.UTF_8);
            return "redirect:/Home?buyError=" + msg;
        }

    }

}
