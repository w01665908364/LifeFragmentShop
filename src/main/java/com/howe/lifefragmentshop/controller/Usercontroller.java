package com.howe.lifefragmentshop.controller;

import com.howe.lifefragmentshop.service.UserService;
import com.howe.lifefragmentshop.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Controller
public class Usercontroller {

    @Autowired
    UserService userService;


    // 显示注册页面（GET 请求）
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";  // 返回 templates/register.html
    }
    @PostMapping("/register")
    public String buy(@ModelAttribute User user,//代表前端提交按钮提交的数据提交到user里
                      @RequestParam("password2") String password2) {
        try {


            //要先进行判空否则回空指针异常
            if(user.getPassword()==null||password2==null){
                String msg = URLEncoder.encode("密码不能为空", StandardCharsets.UTF_8);
                return "redirect:/register?registerError=" + msg;//失败的参数名要统一registerError
            }
            //进行一个密码的判断,不成功就返回到注册页面，并提示报错：两次输入密码不一致
            if(!user.getPassword().equals(password2)){
                //中文不能直接拼到url中，tomcat会丢弃报异常白屏，所以要多这一步
                String msg = URLEncoder.encode("两次输入密码不一致", StandardCharsets.UTF_8);
                return "redirect:/register?registerError=" + msg;
            }

            int flag = userService.addUser(user);//调用service的方法，创建订单,返回更改行数
            //
            if(flag>0){
                //跳转到登录页面
                return "redirect:/Home?registerSuccess=true";//带个成功的标记
            }else {
                String msg = URLEncoder.encode("注册失败", StandardCharsets.UTF_8);
                //注册失败弹窗
                return "redirect:/register?registerError=" + msg;
            }

        } catch (RuntimeException e) {
            // 接住 Service 抛出的异常（已注册或者必传参数没填）还是注册失败返回到注册页面
            String msg = URLEncoder.encode(e.getMessage(), StandardCharsets.UTF_8);
            return "redirect:/register?registerError=" + msg;
        }


    }

}
