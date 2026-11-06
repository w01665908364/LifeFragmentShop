package com.howe.lifefragmentshop.controller;

import com.howe.lifefragmentshop.pojo.LifeFragment;
import com.howe.lifefragmentshop.pojo.User;
import com.howe.lifefragmentshop.pojo.Order;
import com.howe.lifefragmentshop.service.OrderService;
import jakarta.servlet.http.HttpSession;
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
    public String buy(@RequestParam int fragmentId, HttpSession session) {//获取购买的商品id
        try{
            //1.查登录状态
            User loginUser = (User) session.getAttribute("loginUser");//取出loginUser

            // 2. 如果没登录，直接打回登录页
            if (loginUser == null) {
                String msg = URLEncoder.encode("购买失败，请先登录！", StandardCharsets.UTF_8);
                return "redirect:/login?loginError=" + msg;
            }
            //调用service的方法，创建订单,返回更改行数，传入用户id
            int flag = orderService.addOrder(fragmentId,loginUser.getId());

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
    //生命碎片购买记录
    @GetMapping("/admin/orders")
    public String adminOrders(HttpSession session, Model model) {
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "redirect:/login";
        }
        if (!"admin".equals(loginUser.getRole())) {//不是管理员账号也看不了
            return "redirect:/Home?accessDenied=true";
        }

        List<Order> orders = orderService.getOrdersBySellerId(loginUser.getId());
        model.addAttribute("orders", orders);//这里存了后前端用
        return "admin-orders";
    }

}
