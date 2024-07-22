package com.jiang.springdata.repositories;

import com.jiang.springdata.pojo.Customer;
import com.jiang.springdata.pojo.Message;
import com.jiang.springdata.pojo.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
public interface MessageRepository extends PagingAndSortingRepository<Message,Long>{

    // 根据客户id查询所有信息
    // 通过规定方法名来实现关联查询： 需要通过关联属性来进行匹配
    // 但是只能通过id来进行匹配
    List<Message> findByUser(User user);

}
