package cn.zjn.jx.bigdata.dao.sys;

import cn.zjn.jx.bigdata.domain.sys.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: qiaokk
 * @Description:
 * @Date: Created in 2018-05-17 11:43
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
@Mapper
public interface UserDao {

    public User getUserByUsername(@Param("username") String username);


}
