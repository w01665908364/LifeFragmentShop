package com.howe.lifefragmentshop.mapper;
import com.howe.lifefragmentshop.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    //MyBatis的机制#{xxx}就会自动去找getXxx()来映射到这
    @Insert("insert into tb_order " +
            "(fragment_id,seller_id,buyer_id,buy_time,status)" +
            " values(#{fragmentId},#{sellerId},#{buyerId},#{buyTime},#{status})")
    int insertOrder(Order order);
}
