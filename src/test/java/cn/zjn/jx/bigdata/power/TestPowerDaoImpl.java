package cn.zjn.jx.bigdata.power;

import cn.zjn.jx.bigdata.dao.company.CompanyDao;
import cn.zjn.jx.bigdata.domain.power.PowerMeterInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: qiaokk
 * @Description:
 * @Date: Created in 2018-05-11 15:57
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPowerDaoImpl implements TestCompanyDao{


    @Autowired
    CompanyDao companyDao;

    @Override
    @Test
    public void testSelectMeterByCompanyCode() {

        List<PowerMeterInfo> powerMeterInfos = companyDao.selectPowerMeterInfosByCompanyCode("1");
        System.out.println(powerMeterInfos);
    }
}
