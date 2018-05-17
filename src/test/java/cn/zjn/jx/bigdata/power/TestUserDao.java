package cn.zjn.jx.bigdata.power;

import cn.zjn.jx.bigdata.dao.sys.UserDao;
import cn.zjn.jx.bigdata.domain.sys.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: qiaokk
 * @Description:
 * @Date: Created in 2018-05-17 11:56
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserDao {


    @Autowired
    UserDao userDao;

    @Test
    public void testSeUbyName(){
        User u = userDao.getUserByUsername("admin");
        System.out.println(u);


    }


}
