package cn.zjn.jx.bigdata.service.sys;

import cn.zjn.jx.bigdata.domain.sys.User;

/**
 * @Author: qiaokk
 * @Description:
 * @Date: Created in 2018-05-17 11:59
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
public interface UserService {
    public User getUserByUsername(String username);
}
