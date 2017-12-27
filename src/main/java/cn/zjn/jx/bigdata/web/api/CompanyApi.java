package cn.zjn.jx.bigdata.web.api;

import cn.zjn.jx.bigdata.domain.company.CompanyMeterView;
import cn.zjn.jx.bigdata.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017-12-27 17:30
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
@RestController
@RequestMapping("/jx/api/company/")
public class CompanyApi {

    @Autowired
    CompanyService companyService;

    @RequestMapping("/companyInfos")
    public List<CompanyMeterView> getCompanyMeterViews(){
        return companyService.selectCompanyMeterViews();
    }


}
