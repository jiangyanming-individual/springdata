package com.jiang.springdata.crudTest;


import com.jiang.springdata.config.SpringDataJPAConfig;
import com.jiang.springdata.pojo.Customer;
import com.jiang.springdata.repositories.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Optional;


@ContextConfiguration(classes = SpringDataJPAConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CrudTest {

    @Resource
    CustomerRepository repository;

    @Test
    public  void testFind(){
        Optional<Customer> byId = repository.findById(20L);

        System.out.println(byId.orElse(null));
    }

    @Test
    public  void testInsert(){

        Customer customer = new Customer();
        customer.setCustName("李四");

        System.out.println(repository.save(customer));

        Customer customer2 = new Customer();
        customer2.setCustName("王五");

        System.out.println(repository.save(customer2));

        Customer customer3 = new Customer();
        customer3.setCustName("赵六");

        System.out.println(repository.save(customer3));

    }

    @Test
    public  void testDel(){


        Customer customer = new Customer();
        customer.setCustId(3L);
        customer.setCustName("李四");

        repository.delete(customer);
    }


    @Test
    public  void testFindAll(){

        Iterable<Customer> allById = repository.findAllById(Arrays.asList(1L, 7L, 8L));
        System.out.println(allById);
    }
}
