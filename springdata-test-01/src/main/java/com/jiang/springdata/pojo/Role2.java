package com.jiang.springdata.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sys_role")
@Data
public class Role2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;
    @Column(name = "role_name")
    private String roleName;

    //配置多对多
//    @ManyToMany(targetEntity = User.class)
//    @JoinTable(name = "sys_user_role",
//            joinColumns = {@JoinColumn(name = "sys_role_id", referencedColumnName = "role_id")},
//            inverseJoinColumns = {@JoinColumn(name = "sys_user_id", referencedColumnName = "user_id")}
//    )
    @ManyToMany()  //配置多表关系
    private Set<User2> users = new HashSet<User2>();
}
