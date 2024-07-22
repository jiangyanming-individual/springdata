package com.jiang.springdata.crudTest;


import com.jiang.springdata.config.SpringDataJPAConfig;
import com.jiang.springdata.pojo.Customer;
import com.jiang.springdata.repositories.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;


/**
 * 自定义jpql
 */

@ContextConfiguration(classes = SpringDataJPAConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class JpqlTest {


    @Resource
    CustomerRepository repository;


    @Test
    public void testFindCustomerByCustName(){
        List<Customer> list = repository.findCustomerByCustName("李四");
        System.out.println(list);
    }

    @Test
    public void testUpdateCustomerById(){
        int b = repository.updateNameById("zhaoliu6666", 6L);
        System.out.println(b);
    }


    @Test
    public void testDelCustomerById(){
        int b = repository.delCustomerById(7L);
        System.out.println("删除成功："+b);
    }

    @Test
    public void findAllCustomer(){
        List<Customer> list = repository.findCustomerByCustNameBySql("李四");
        System.out.println(list);
    }

}
