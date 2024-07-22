package com.jiang.springdata.crudTest;


import com.jiang.springdata.config.SpringDataJPAConfig;
import com.jiang.springdata.pojo.Customer;
import com.jiang.springdata.pojo.QCustomer;
import com.jiang.springdata.repositories.CustomerQueryDSLRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Optional;

@ContextConfiguration(classes = SpringDataJPAConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class QueryDSLTest {

    @Resource
    CustomerQueryDSLRepository repository;


    @Test
    public  void test01() {
        QCustomer customer = QCustomer.customer;
        // 通过Id查找
        BooleanExpression eq = customer.custId.eq(1L);
        System.out.println(repository.findOne(eq));
    }


    /**
     *查询断言：
     */
    @Test
    public  void test02() {
        QCustomer customer = QCustomer.customer;
        BooleanExpression and = customer.custName.in("李四", "王五")
                .and(customer.custId.gt(0L))
                .and(customer.custAddress.eq("beijing"));

        Iterable<Customer> all = repository.findAll(and);
        System.out.println(all);
    }

}
