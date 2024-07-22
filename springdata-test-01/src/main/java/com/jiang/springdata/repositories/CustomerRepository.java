package com.jiang.springdata.repositories;

import com.jiang.springdata.pojo.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 基本的crud操作：
 */
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    /**
     * 查询
     *
     */
    @Query("FROM Customer where custName=:custName ")
    List<Customer> findCustomerByCustName(@Param("custName") String custName);


    /**
     * 更新
     * @param custName
     * @param id
     * @return
     */
    @Transactional
    @Modifying
    @Query("UPDATE Customer c set c.custName=:custName where c.custId=:id")
    int updateNameById(@Param("custName") String custName, @Param("id") Long id);


    /**
     * 删除
     * @param id
     * @return
     */
    @Transactional
    @Modifying
    @Query("delete Customer c where c.custId=:id")
    int delCustomerById(@Param("id") Long id);

    //原生的sql查询
    @Query(value="select * FROM tb_customer where cust_name=:custName "
            ,nativeQuery = true)
    List<Customer> findCustomerByCustNameBySql(@Param("custName") String custName);

}