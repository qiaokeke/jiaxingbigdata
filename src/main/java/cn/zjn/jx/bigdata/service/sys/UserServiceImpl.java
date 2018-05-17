package cn.zjn.jx.bigdata.service.sys;

import cn.zjn.jx.bigdata.dao.sys.UserDao;
import cn.zjn.jx.bigdata.domain.sys.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: qiaokk
 * @Description:
 * @Date: Created in 2018-05-17 12:01
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }
}
