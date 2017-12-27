package cn.zjn.jx.bigdata.dao.company;

import cn.zjn.jx.bigdata.domain.company.CompanyInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017-12-27 17:35
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
@Mapper
public interface CompanyDao {

    @Select({"SELECT \n" +
            "company_info.company_code AS companyCode,\n" +
            "company_info.company_name AS companyName\n" +
            "FROM\n" +
            "company_info\n"})
    public List<CompanyInfo> selectCompanyInfos();


}
