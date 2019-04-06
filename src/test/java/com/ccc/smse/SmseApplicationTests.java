package com.ccc.smse;

import com.ccc.smse.dao.TestUserRepository;
import com.ccc.smse.dao.WebMenuRepository;
import com.ccc.smse.pojo.TestUser;
import com.ccc.smse.pojo.WebMenu;
import com.ccc.smse.pojo.WebMenuSecond;
import com.ccc.smse.service.WebMenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLOutput;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmseApplicationTests {
    @Autowired
    private TestUserRepository testUserRepositoryl;
    @Autowired
    private WebMenuRepository webMenuRepository;

    @Autowired
    private WebMenuService webMenuService;
    @Test
    public void contextLoads() {
        System.out.println("------>test");
    }

    @Test
    public void testData(){
        TestUser testUser = new TestUser();
        testUser.setId(1);
        this.testUserRepositoryl.delete(testUser);
    }

    @Test
    public void addMenu(){
        WebMenu webMenu = new WebMenu();
       // WebMenuSecond webMenuSecond1 = new WebMenuSecond();
//        webMenu.setId("1");
//        webMenu.setShowName("芯片良率");
//        webMenu.setHref("index");
//        webMenu.setParams("jumpto=chipYield");
//        webMenu.setIron("<i class=\"fa fa-rocket\"></i>");
        webMenu.setId("2");
        webMenu.setShowName("数据处理");
        webMenu.setHref("index");
        webMenu.setParams("jumpto=data");
        webMenu.setIron("<i class=\"fa fa-tasks\"></i>");
        webMenuRepository.save(webMenu);
    }

    @Test
    public void testMenu(){
        System.out.println(webMenuService.findAll());
    }

    @Test
    public void  testDelete(){
        webMenuRepository.delete(new WebMenu().setId("1"));
    }

}
