package com.jiang.springdata.mappingTest;


import com.jiang.springdata.config.SpringDataJPAConfig;
import com.jiang.springdata.pojo.Message;
import com.jiang.springdata.pojo.User;
import com.jiang.springdata.repositories.MessageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@ContextConfiguration(classes = SpringDataJPAConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ManyToOneTest {


    @Resource
    MessageRepository repository;


    @Test
    public void testFindMessage(){

        //多对1
        User user = new User();
        user.setUserName("是蚂蚁");
        // 多
        List<Message> list=new ArrayList<>();
        Message message1 = new Message("你好", user);
        Message message2 = new Message("在吗？", user);
        list.add(message1);
        list.add(message2);
        repository.saveAll(list);

    }


    @Test
    public void testGetUser(){

        User user = new User();
        user.setUserId(9L);
        List<Message> messageList = repository.findByUser(user);
        System.out.println(messageList);
    }

}
