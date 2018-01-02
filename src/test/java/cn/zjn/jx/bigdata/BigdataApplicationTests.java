package cn.zjn.jx.bigdata;

import cn.zjn.jx.bigdata.utils.TimeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BigdataApplicationTests {

	@Test
	public void contextLoads() {
	}


	@Test
	public void testgetTswkDate(){
		Map<Integer,String> map =  TimeUtil.getYdayDate();
		System.out.println(map.get(1));
		System.out.println(map.get(2));
		System.out.println(map.get(3));
	}
}
