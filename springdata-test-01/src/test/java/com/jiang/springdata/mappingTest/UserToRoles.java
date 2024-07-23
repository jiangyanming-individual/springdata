package com.jiang.springdata.mappingTest;


import com.jiang.springdata.config.SpringDataJPAConfig;
import com.jiang.springdata.pojo.Role2;
import com.jiang.springdata.pojo.User;
import com.jiang.springdata.pojo.User2;
import com.jiang.springdata.repositories.Role2Repository;
import com.jiang.springdata.repositories.User2Repository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@ContextConfiguration(classes = SpringDataJPAConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class UserToRoles {

    @Resource
    User2Repository user2Repository;

    @Resource
    Role2Repository role2Repository;

    @Test
    @Transactional
    @Commit
    public void add() {
        User2 user2 = new User2();
        user2.setUserName("阳仔");

        Role2 role2 = new Role2();
        role2.setRoleName("Java程序员");
        user2.getRoles().add(role2);

        user2Repository.save(user2);
        role2Repository.save(role2);
    }


}
