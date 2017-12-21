package cn.zjn.jx.bigdata.utils;

import cn.zjn.jx.bigdata.domain.power.PowerZXYGDNHoursView;

import java.util.List;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017-12-21 22:12
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
public class SubValueUtil {

    public static void subValue(List<PowerZXYGDNHoursView> views){
        if (views.size()==0)
            return;

        for(int i=views.size()-1;i>0;i--){
            views.get(i).setZXYGDN(views.get(i).getZXYGDN()-views.get(i-1).getZXYGDN());
        }
        views.get(0).setZXYGDN(0);
    }





}
