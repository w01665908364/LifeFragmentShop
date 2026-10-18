    package com.howe.lifefragmentshop.service;

    import com.howe.lifefragmentshop.mapper.LifeFragmentMapper;
    import com.howe.lifefragmentshop.mapper.OrderMapper;
    import com.howe.lifefragmentshop.mapper.UserMapper;
    import com.howe.lifefragmentshop.pojo.LifeFragment;
    import com.howe.lifefragmentshop.pojo.Order;
    import jakarta.servlet.http.HttpSession;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import org.springframework.transaction.annotation.Transactional;

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
        //事务的使用，就是后面如果有throw抛出异常，程序就会自动回滚撤销上面的代码
        @Transactional//事务，会回滚
        public int addOrder(int fragmentId,int userID) {

            // 1. 先查商品
            LifeFragment lifeFragment = lifeFragmentMapper.selectById(fragmentId);

            // 2. 判空（一定要在用它之前！）
            if (lifeFragment == null) {
                throw new RuntimeException("商品不存在！");
            }

            // 3. 判断状态是否上架
            if (lifeFragment.getState() != 1) {
                throw new RuntimeException("商品已下架！");
            }

            // 4. 扣库存（传方法参数 fragmentId，不是 order.getFragmentId()）
            int result = lifeFragmentMapper.decreaseStock(fragmentId);
            if (result == 0) {
                throw new RuntimeException("库存不足！");
            }

            // 5. 扣减成功后，再构建订单
            Order order = new Order();
            order.setFragmentId(lifeFragment.getId());
            order.setSellerId(lifeFragment.getSellerId());
            order.setBuyerId(userID);
            order.setStatus(0);

            // 6. 插入订单
            return orderMapper.insertOrder(order);
        }
    }
