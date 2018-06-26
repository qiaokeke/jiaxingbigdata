package cn.zjn.jx.bigdata.power;

import cn.zjn.jx.bigdata.utils.TimeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: qiaokk
 * @Description:
 * @Date: Created in 2018-06-13 15:22
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTime {


    @Test
    public void testTd(){

        System.out.println(TimeUtil.TDayETimeString);
    }
}
