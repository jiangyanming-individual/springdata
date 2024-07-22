package com.jiang.springdata.repositories;

import com.jiang.springdata.pojo.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

/**
 * Query Example
 */
public interface CustomerQueryERepository
        extends PagingAndSortingRepository<Customer,Long>,
        QueryByExampleExecutor<Customer> {
}
