package com.jiang.springdata.mappingTest;


import com.jiang.springdata.config.SpringDataJPAConfig;
import com.jiang.springdata.pojo.Account;
import com.jiang.springdata.pojo.Customer;
import com.jiang.springdata.pojo.User;
import com.jiang.springdata.repositories.CustomerRepository;
import com.jiang.springdata.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@ContextConfiguration(classes = SpringDataJPAConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class OneToOneTest {


    @Resource
    UserRepository repository;

    /**
     * 1对1；
     */
    @Test
    public void saveTest(){
        Account account = new Account();
        account.setUsername("jiangyanming");
        account.setPassword("12345678");


        User user = new User();
        user.setUserName("jym");
        user.setUserAddress("shanghai");
        user.setAccount(account);

        account.setUser(user);
        User save = repository.save(user);
        System.out.println(save);
    }

    @Test
    public void delTest(){
        repository.deleteById(4L);
    }

}
