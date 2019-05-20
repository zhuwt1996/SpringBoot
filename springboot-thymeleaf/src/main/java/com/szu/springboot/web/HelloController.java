package com.szu.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhuwutao on 2019/5/20
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public String index(ModelMap modelMap){
        modelMap.addAttribute("message","http://www.zhuwutao.com");
        return "hello";
    }
}
