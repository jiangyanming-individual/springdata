package com.jiang.springdata.mappingTest;


import com.jiang.springdata.config.SpringDataJPAConfig;
import com.jiang.springdata.pojo.Role;
import com.jiang.springdata.pojo.User;
import com.jiang.springdata.repositories.RoleRepository;
import com.jiang.springdata.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@ContextConfiguration(classes = SpringDataJPAConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ManyToManyTest {
    @Resource
    UserRepository userRepository;
    
    
    @Resource
    RoleRepository roleRepository;



    @Test
    @Transactional
    @Commit
    public void testRoleSave(){

        Role role = new Role();
        role.setRName("1");
        roleRepository.save(role);

        Role role1 = new Role();
        role1.setRName("2");
        roleRepository.save(role1);

    }

    /**
     * 多对多的情况下：
     */
    @Test
    @Transactional
    @Commit
    public void testSave(){

        List<Role> roleList=new ArrayList<>();
        
        Role role = new Role();
        roleList.add(roleRepository.findById(1L).get());
        roleList.add(roleRepository.findById(2L).get());

        User user = new User();
        user.setUserName("gege");
        user.setUserAddress("shanghai");
        user.setRoles(roleList);

        User save = userRepository.save(user);
        System.out.println(save);
    }
    
}
