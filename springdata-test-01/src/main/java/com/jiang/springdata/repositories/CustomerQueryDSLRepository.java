package com.jiang.springdata.repositories;

import com.jiang.springdata.pojo.Customer;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 * Query dsl断言：
 */
public interface CustomerQueryDSLRepository extends
        PagingAndSortingRepository<Customer,Long>
          , QuerydslPredicateExecutor<Customer> {

}