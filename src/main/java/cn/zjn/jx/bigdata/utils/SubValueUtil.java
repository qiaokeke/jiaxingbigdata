package cn.zjn.jx.bigdata.utils;

import cn.zjn.jx.bigdata.domain.power.*;

import java.util.List;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017-12-21 22:12
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
public class SubValueUtil {

    public static void subValueOfPowerZXYGDNHoursViews(List<PowerZXYGDNHoursView> views){
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



    public static void subValueOfPowerZXYGDNViews(List<PowerZXYGDNView> views){
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


    public static void subValueOfPowerZJFPGViews(List<PowerZJFPGView> views){
        if (views.size()==0)
            return;
        for(int i=views.size()-1;i>0;i--){
            float subValueZ = views.get(i).getZxygdnZ()-views.get(i-1).getZxygdnZ();
            float subValueJ = views.get(i).getZxygdnJ()-views.get(i-1).getZxygdnJ();
            float subValueF = views.get(i).getZxygdnF()-views.get(i-1).getZxygdnF();
            float subValueP = views.get(i).getZxygdnP()-views.get(i-1).getZxygdnP();
            float subValueG = views.get(i).getZxygdnG()-views.get(i-1).getZxygdnG();

            if(views.get(i-1).getZxygdnZ()==0||subValueZ==0){
                subValueZ=0;
                subValueJ=0;
                subValueF=0;
                subValueP=0;
                subValueG=0;
            }


            views.get(i).setZxygdnZ(subValueZ);
            views.get(i).setZxygdnJ(subValueJ);
            views.get(i).setZxygdnF(subValueF);
            views.get(i).setZxygdnP(subValueP);
            views.get(i).setZxygdnG(subValueG);
        }
       views.remove(0);
    }





}
