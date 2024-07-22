package com.jiang.springdata.crudTest;


import com.jiang.springdata.config.SpringDataJPAConfig;
import com.jiang.springdata.pojo.Customer;
import com.jiang.springdata.repositories.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@ContextConfiguration(classes = SpringDataJPAConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class PaginationAndSortTest {

    @Resource
    CustomerRepository repository;

    /**
     * 分页查询
     */
    @Test
    public void testPagination(){
        Page<Customer> page = repository.findAll(PageRequest.of(0, 2));
        System.out.println(page.getTotalPages()); //一共分为几页
        System.out.println(page.getTotalElements()); //全部的条数
        System.out.println(page.getSize()); //分页的大小
        System.out.println(page.getContent()); //分页的内容

    }

    /**
     * 排序
     */
    @Test
    public void testSort(){

        Sort sort = Sort.by("custId").descending();//降序，操作实体类
        Iterable<Customer> all = repository.findAll(sort);
        System.out.println(all);
    }


    /**
     * 按照类的属性
     */
    @Test
    public void testSortTypeSafe(){
        Sort.TypedSort<Customer> sortType = Sort.sort(Customer.class);
        Sort sort = sortType.by(Customer::getCustId).descending();
        Iterable<Customer> all = repository.findAll(sort);
        System.out.println(all);
    }
}
