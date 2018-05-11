package cn.zjn.jx.bigdata.utils;

import cn.zjn.jx.bigdata.domain.power.PowerZXYGDNInfo;
import cn.zjn.jx.bigdata.domain.power.PowerZXYGDNView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: qiaokk
 * @Description: 用于合并时间相同的电能值（info），并转为(view)
 * @Date: Created in 2018-05-11 21:05
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
public class MergeUtil {


    public static List<PowerZXYGDNView> mergeZXYGDNInfos2Views(List<PowerZXYGDNInfo> infos){
        List<PowerZXYGDNView> views = new ArrayList<>();

        for (PowerZXYGDNInfo info:infos){
            boolean isAdd = false;
            for(PowerZXYGDNView view:views){
                if(view.getTime().equals(info.getTime())){
                    view.setZXYGDN(view.getZXYGDN()+info.getZXYGDN());
                    isAdd =true;
                }
            }
            if (isAdd) continue;
            PowerZXYGDNView view = new PowerZXYGDNView();
            view.setTime(info.getTime());
            view.setZXYGDN(info.getZXYGDN());

            views.add(view);

        }
        return views;
    }

}
