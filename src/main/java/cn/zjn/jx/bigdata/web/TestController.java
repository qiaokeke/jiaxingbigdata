package cn.zjn.jx.bigdata.web;

import cn.zjn.jx.bigdata.service.sys.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017-12-21 17:23
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
@Controller
@RequestMapping("/jx/test")
public class TestController {



    @Autowired
    UserService userService;


    @RequestMapping
    @ResponseBody
    public String test(){
        return "test";
    }

    @RequestMapping("/index")
    public String index(){
        return "huzhou/login";
    }


    @RequestMapping("/roles")
    @ResponseBody
    public Set<String> roles(){
        Subject subject = SecurityUtils.getSubject();

        if (subject.hasRole("admin"))
            System.out.println("adminddddd");

        String username = (String) subject.getPrincipal();

        return userService.getRolesByUsername(username);
    }
}
