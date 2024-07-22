package com.jiang.springdata.crudTest;


import com.jiang.springdata.config.SpringDataJPAConfig;
import com.jiang.springdata.pojo.Customer;
import com.jiang.springdata.repositories.CustomerSpecificationsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * 特定条件查询
 */
@ContextConfiguration(classes = SpringDataJPAConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SpecificationTest {



    @Resource
    CustomerSpecificationsRepository repository;


    @Test
    public void testSpecification(){
        List<Customer> list = repository.findAll(new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                // root from Customer  , 获取列
                // CriteriaBuilder where 设置各种条件  (> < in ..)
                // query  组合（order by , where)

                Path<Long> custId = root.get("custId");
                Path<String> custName = root.get("custName");
                Path<String> custAddress = root.get("custAddress");

                // 参数1 ：为哪个字段设置条件   参数2：值
                Predicate custAddressP = cb.equal(custAddress, "BEIJING");
                Predicate custIdP = cb.greaterThan(custId, 0L);
                CriteriaBuilder.In<String> in = cb.in(custName);
                in.value("徐庶").value("王五");
                Predicate and = cb.and(custAddressP, custIdP, in);
                return and;
            }
        });
        System.out.println(list);
    }
}
