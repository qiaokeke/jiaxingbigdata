package cn.zjn.jx.bigdata.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    @RequestMapping("/jiaxing/main")
    public String index(){
        return "jiaxing/main";
    }

    @RequestMapping(value = "/jiaxing/indexDnhgl")
    public String rootIndexDnhgl(){
        return "/jiaxing/root_index_dnhgl";
    }

    @RequestMapping("/jiaxing/login")
    public String login(){
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated())
            return "jiaxing/main";
        return "jiaxing/login";
    }

    @RequestMapping(value = "/jiaxing/yqfw")
    public String rootService(){
        return "jiaxing/root_index_yqfw";
    }

    @RequestMapping(value = "/jiaxing/rootSsjc")
    public String rootDetection(){
        return "jiaxing/root_index_ssjc";
    }

    @RequestMapping(value = "/jiaxing/userSsjc")
    public String userDetection(){
        return "jiaxing/user_index_ssjc";
    }

    @RequestMapping(value = "/jiaxing/rootSsjcMap")
    public String rootMap(){
        return "jiaxing/root_ssjc_map";
    }
    @RequestMapping(value = "/jiaxing/ssjcMap")
    public String userMap(){
        return "jiaxing/user_ssjc_map";
    }
    @RequestMapping(value = "/jiaxing/rootDb")
    public String rootAnalysis(){
        return "jiaxing/root_index_db";
    }
    @RequestMapping(value = "/jiaxing/userDb")
    public String userAnalysis(){
        return "jiaxing/user_index_db";
    }
    @RequestMapping(value = "/jiaxing/rootWarning")
    public String rootWarning(){
        return "jiaxing/root_eletricWarnning";
    }
    @RequestMapping(value = "/jiaxing/userWarning")
    public String userWarning(){
        return "jiaxing/user_eletricWarnning";
    }

    @RequestMapping(value = "/jiaxing/rootScreen")
    public String rootScreen(){
        return "jiaxing/root_jiaxing_screen";
    }
    @RequestMapping(value = "/jiaxing/rootManager")
    public String rootManager(){
        return "jiaxing/root_manager";
    }
    @RequestMapping(value = "/jiaxing/rootSingleData")
    public String rootSingle(){
        return "jiaxing/root_single_data";
    }

    @RequestMapping(value = "/jiaxing/userExamination")
    public String userExamination(){
        return "jiaxing/user_examination";
    }

    @RequestMapping(value = "/jiaxing/note")
    public String note(){
        return "jiaxing/note";
    }

    @RequestMapping(value = "/jiaxing/report")
    public String report(){
        return "jiaxing/report";
    }

    @RequestMapping(value = "/jiaxing/mainMap")
    public String mainMap(){
        return "jiaxing/main_map";
    }
}
