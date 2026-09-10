package com.howe.lifefragmentshop.service;

import com.howe.lifefragmentshop.mapper.LifeFragmentMapper;
import com.howe.lifefragmentshop.mapper.OrderMapper;
import com.howe.lifefragmentshop.pojo.LifeFragment;
import com.howe.lifefragmentshop.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/*要写订单的逻辑代码
1、要调用OrderMapper来访问数据库，
2、要获得Order信息并返回给mapper
3、要判断前端的信息能否符合属性要求，符合才插入
 */
@Service
public class OrderService {

    @Autowired private OrderMapper orderMapper;
    @Autowired private LifeFragmentMapper lifeFragmentMapper;
    //控制层传一个生命碎片的id就行了
    public int addOrder(int fragmentId){

        //先不实现。。。
        //判断购买时间是否符合常理
        //判断当前商品的销方是否存在
        //判断当前登录的用户id就是购方id
        //判断商品是否存在
        //判断商品状态是否上架
        //判断商品库存是否大于购买数量，并且大于0，就扣除
        //判断用户的购买资格是否能买起，并扣除

        //先实现创造一个order然后改数据库。
        //
        Order order = new Order();
        LifeFragment lifeFragment = new LifeFragment();

        //查询当前登录用户，为购方id
        //调用set设置到order中，但是怎么获取其他的属性呢？
        //要知道碎片id、销方id、购方id、购买时间、状态
        lifeFragment = lifeFragmentMapper.selectById(fragmentId);//查生命碎片的信息
        order.setFragmenId(lifeFragment.getId());//订单赋值：碎片id
        order.setSellerId();//订单赋值：销方id
        //订单赋值：购方id
        order.setBuyTime(String.valueOf(LocalDateTime.now()));//订单赋值：购买时间
        order.setStatus(1);//订单赋值：状态


        //调用mapper改数据库，改完返回
        return orderMapper.insertOrder(order);//返回数据库改变几行
    }
}
