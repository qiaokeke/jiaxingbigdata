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
            float subValue = views.get(i).getZXYGDN()-views.get(i-1).getZXYGDN();
            if(views.get(i-1).getZXYGDN()==0){
                subValue=0;
            }
            if (subValue<0)
                subValue=0;
            views.get(i).setZXYGDN(subValue);
        }
        views.get(0).setZXYGDN(0);
    }





}
