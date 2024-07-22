package com.jiang.springdata.repositories;

import com.jiang.springdata.pojo.Customer;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerSpecificationsRepository
        extends PagingAndSortingRepository<Customer,Long>,
        JpaSpecificationExecutor<Customer> {

}