package com.jiang.springdata.repositories;

import com.jiang.springdata.pojo.Customer;
import com.jiang.springdata.pojo.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 基本的crud操作：
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}