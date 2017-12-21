package cn.zjn.jx.bigdata.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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




    @RequestMapping
    @ResponseBody
    public String test(){
        return "test";
    }

    @RequestMapping("/index")
    public String index(){
        return "huzhou/login";
    }

}
