package com.jiang.springdata.mappingTest;

import com.jiang.springdata.config.SpringDataJPAConfig;
import com.jiang.springdata.pojo.Account;
import com.jiang.springdata.pojo.Customer;
import com.jiang.springdata.pojo.Message;
import com.jiang.springdata.pojo.User;
import com.jiang.springdata.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ContextConfiguration(classes = SpringDataJPAConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class OneToManyTest {

    @Resource
    UserRepository repository;

    /**
     * 1对多
     */
    @Test
    public void saveTest() {

        User user = new User();

        user.setUserName("jack");
        user.setUserAddress("shanghai");
        user.setAccount(null);

        List<Message> messageList = new ArrayList<>();
        Message message1 = new Message();
        message1.setInfo("你好");
        messageList.add(message1);
        Message message2 = new Message();
        message2.setInfo("我在的");
        messageList.add(message2);

        user.setMessage(messageList);
        User save = repository.save(user);
        System.out.println(save);

    }


    @Test
    @Transactional(readOnly = true)
    public void testR(){
        // 懒加载过程：
        // 1.findById  只会查询Customer 和其他关联的立即加载
        Optional<User> user = repository.findById(5L);
        System.out.println("=====================");
        // 由于输出， 会自动调用customer.toString()
        System.out.println(user);
    }

}
