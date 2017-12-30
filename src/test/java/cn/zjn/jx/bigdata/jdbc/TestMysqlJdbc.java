package cn.zjn.jx.bigdata.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017-12-29 15:28
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMysqlJdbc {
    public static final String url = "jdbc:mysql://122.112.211.120:4040/huzhou";
    public static final String name = "com.mysql.jdbc.Driver";
    public static final String user = "root";
    public static final String password = "cecepJX#2018DB";
    public static final String sql="SELECT\n" +
            "W_ADDRESS\n" +
            "FROM\n" +
            "tbl_water_info\n" +
            "GROUP BY\n" +
            "W_ADDRESS";

    public Connection conn = null;
    public PreparedStatement pst = null;
    static ResultSet ret = null;


    @Test
    public void testJdbc(){
        try {
            Class.forName(name);//指定连接类型
            conn = DriverManager.getConnection(url, user, password);//获取连接
            pst = conn.prepareStatement(sql);//准备执行语句
            ret =pst.executeQuery();
            while (ret.next()) {
                String uid = ret.getString(1);
                System.out.println(uid );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
