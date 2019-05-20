package com.szu.springboot.web;

import com.szu.springboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuwutao on 2019/5/20
 */
@Controller
public class ExampleController {

    @RequestMapping("/string")
    public String string(ModelMap map){
        map.addAttribute("username","zhuwutao");
        return "string";
    }

    @RequestMapping("/if")
    public String ifunless(ModelMap map){
        map.addAttribute("flag","yes");
        return "if";
    }

    @RequestMapping("/list")
    public String list(ModelMap map) {
        map.addAttribute("users", getUserList());
        return "list";
    }

    @RequestMapping("/url")
    public String url(ModelMap map) {
        map.addAttribute("type", "link");
        map.addAttribute("pageId", "spring-boot/2019/05/20/");
        map.addAttribute("img", "http://www.baidu.com");
        return "url";
    }

    @RequestMapping("/eq")
    public String eq(ModelMap map) {
        map.addAttribute("name", "zhuwutao");
        map.addAttribute("age", 30);
        map.addAttribute("flag", "yes");
        return "eq";
    }

    @RequestMapping("/switch")
    public String switchcase(ModelMap map) {
        map.addAttribute("sex", "woman");
        return "switch";
    }

    private List<User> getUserList(){
        List<User> list=new ArrayList<User>();
        User user1=new User("zhuwutao",18,"123456");
        User user2=new User("xiaoxia",16,"123563");
        User user3=new User("zhuzhuzhu",3,"666666");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        return  list;
    }
}
