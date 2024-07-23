package com.jiang.springdata.repositories;

import com.jiang.springdata.pojo.Role;
import com.jiang.springdata.pojo.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 基本的crud操作：
 */
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {

}