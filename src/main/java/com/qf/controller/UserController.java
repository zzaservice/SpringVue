package com.qf.controller;

import com.qf.pojo.Msg;
import com.qf.pojo.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService us;
    @RequestMapping("/all/{page}/{pagerow}")
    public Msg selectAll(@PathVariable("page") int page,@PathVariable("pagerow") int pagerow) {
        System.out.println("这是8085的");
        Msg msg = us.selectAll(page, pagerow);
        return msg;
    }
   @RequestMapping(value = "/one/{userid}",method = RequestMethod.POST)
    public User selectOne(@PathVariable("userid")int userid){
        System.out.println(userid);
     return  us.selectOne(userid);
    }
   @RequestMapping("/de")
    public String de(@RequestBody User user){
       System.out.println(user.getUserid());
              return   us.de(user);
    }
    @RequestMapping("/upuser")
    public User up(@RequestBody User user){
        return  us.up(user);
    }

}
