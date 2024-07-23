package com.jiang.springdata.repositories;

import com.jiang.springdata.pojo.Role;
import com.jiang.springdata.pojo.Role2;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 基本的crud操作：
 */
public interface Role2Repository extends PagingAndSortingRepository<Role2, Long> {

}