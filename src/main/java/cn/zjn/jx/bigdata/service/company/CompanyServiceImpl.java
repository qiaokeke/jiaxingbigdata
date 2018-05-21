package cn.zjn.jx.bigdata.service.company;

import cn.zjn.jx.bigdata.dao.company.CompanyDao;
import cn.zjn.jx.bigdata.dao.power.PowerDao;
import cn.zjn.jx.bigdata.domain.company.CompanyInfo;
import cn.zjn.jx.bigdata.domain.company.CompanyMeterView;
import cn.zjn.jx.bigdata.domain.power.PowerMeterInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017-12-27 17:50
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyDao companyDao;

    @Autowired
    PowerDao powerDao;

    @Override
    public List<CompanyMeterView> selectCompanyMeterViews() {
        Subject subject = SecurityUtils.getSubject();
        List<CompanyInfo> infos = new ArrayList<>();
        if(subject.hasRole("admin"))
            infos = companyDao.selectCompanyInfos();
       else
           infos = companyDao.selectCompanyInfosByUsername((String) subject.getPrincipal());

        List<CompanyMeterView> views = new ArrayList<>();
        for (CompanyInfo info:infos){
            CompanyMeterView view = new CompanyMeterView();
            view.setCompanyCode(info.getCompanyCode());
            view.setCompanyName(info.getCompanyName());
            List<PowerMeterInfo> powerMeterInfos = powerDao.selectPowerMeterInfosByCompanyCode(info.getCompanyCode());
            view.setPowerMeterInfos(powerMeterInfos);
            views.add(view);
        }
        return views;
    }
}
