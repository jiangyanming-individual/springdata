package com.jiang.springdata.crudTest;


import com.jiang.springdata.config.SpringDataJPAConfig;
import com.jiang.springdata.pojo.Customer;
import com.jiang.springdata.repositories.CustomerQueryERepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@ContextConfiguration(classes = SpringDataJPAConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class QueryExampleTest {


    @Resource
    CustomerQueryERepository customerQueryERepository;


    /**
     * 测试Example
     */
    @Test
    public void testExample(){
        Customer customer = new Customer();
        customer.setCustName("李四");

        Example<Customer> customerExample = Example.of(customer);
        System.out.println(customerQueryERepository.findAll(customerExample));
    }


    @Test
    public void testExampleMatcher(){
        Customer customer = new Customer();
        customer.setCustAddress("beijing");
        //匹配设置更多的条件
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnoreCase("custAddress");
        Example<Customer> customerExample = Example.of(customer, exampleMatcher);
        System.out.println(customerQueryERepository.findAll(customerExample));
    }

}
