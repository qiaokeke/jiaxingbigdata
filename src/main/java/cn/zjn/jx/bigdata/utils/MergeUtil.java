package cn.zjn.jx.bigdata.utils;

import cn.zjn.jx.bigdata.domain.power.PowerZJFPGInfo;
import cn.zjn.jx.bigdata.domain.power.PowerZJFPGView;
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

    public static List<PowerZJFPGView> mergeZJFPGInfos2Views(List<PowerZJFPGInfo> infos){
        List<PowerZJFPGView> views = new ArrayList<>();

        for (PowerZJFPGInfo info:infos){
            boolean isAdd = false;
            for(PowerZJFPGView view:views){
                if(view.getTime().equals(info.getTime())){
                    view.setZxygdnZ(view.getZxygdnZ()+info.getZxygdnZ());
                    view.setZxygdnJ(view.getZxygdnJ()+info.getZxygdnJ());
                    view.setZxygdnF(view.getZxygdnF()+info.getZxygdnF());
                    view.setZxygdnP(view.getZxygdnP()+info.getZxygdnP());
                    view.setZxygdnG(view.getZxygdnG()+info.getZxygdnG());
                    isAdd =true;
                }
            }
            if (isAdd) continue;
            PowerZJFPGView view = new PowerZJFPGView();
            view.setTime(info.getTime());
            view.setZxygdnZ(info.getZxygdnZ());
            view.setZxygdnJ(info.getZxygdnJ());
            view.setZxygdnF(info.getZxygdnF());
            view.setZxygdnP(info.getZxygdnP());
            view.setZxygdnG(info.getZxygdnG());
            views.add(view);
        }
        return views;
    }
}
