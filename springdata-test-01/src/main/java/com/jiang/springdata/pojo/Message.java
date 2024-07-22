package com.jiang.springdata.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity     // 作为hibernate 实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_message")       // 映射的表明
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String info;

    public Message(String info, User user) {
        this.info = info;
        this.user = user;
    }

    //多对1
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.LAZY)
    // 设置外键的字段名
    @JoinColumn(name = "user_id")
    private User user;

}
