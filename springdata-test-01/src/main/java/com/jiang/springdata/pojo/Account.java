package com.jiang.springdata.pojo;

import lombok.Data;

import javax.persistence.*;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 *
 * 一对一
 * 一个客户对一个账户
 */
@Entity
@Table(name="tb_account")
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自动生成的
    private Long id;

    private String username;

    private String password;

    /**
     * 关联表：1对1：
     */
    @OneToOne
    @JoinColumn(name="user_id") //外键id;
    private User user;

}
