package com.ccc.smse;

import com.ccc.smse.dao.TestUserRepository;
import com.ccc.smse.pojo.TestUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmseApplicationTests {
    @Autowired
    private TestUserRepository testUserRepositoryl;
    @Test
    public void contextLoads() {
        System.out.println("------>test");
    }

    @Test
    public void testData(){
        TestUser testUser = new TestUser();
        testUser.setId(2);
        testUser.setName("张三");
        this.testUserRepositoryl.save(testUser);
    }

}
