package com.howe.lifefragmentshop.mapper;
import com.howe.lifefragmentshop.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {

    //MyBatis的机制#{xxx}就会自动去找getXxx()来映射到这
    @Insert("insert into tb_order " +
            "(fragment_id,seller_id,buyer_id,status)" +
            " values(#{fragmentId},#{sellerId},#{buyerId},#{status})")
    int insertOrder(Order order);//插入一条订单

    //用销方id查询所有订单（sql语句中起了别名，这样实体类order就能接住）
    @Select("SELECT o.id, o.fragment_id AS fragmentId, o.seller_id AS sellerId, " +
            "o.buyer_id AS buyerId, o.buy_time AS buyTime, o.finish_time AS finishTime, " +
            "o.status, u.username AS buyerUsername, u.nickname AS buyerNickname, " +
            "f.name AS fragmentName " +
            "FROM tb_order o " +
            "LEFT JOIN tb_user u ON o.buyer_id = u.id " +
            "LEFT JOIN life_fragment f ON o.fragment_id = f.id " +
            "WHERE o.seller_id = #{sellerId} ORDER BY o.id DESC")
    List<Order> findBySellerId(@Param("sellerId") int sellerId);
}
