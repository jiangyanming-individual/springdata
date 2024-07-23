package com.jiang.springdata.repositories;

import com.jiang.springdata.pojo.User;
import com.jiang.springdata.pojo.User2;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 基本的crud操作：
 */
public interface User2Repository extends PagingAndSortingRepository<User2, Long> {

}