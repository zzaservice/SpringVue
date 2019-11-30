package com.qf.service.impl;

import com.qf.pojo.Msg;
import com.qf.pojo.User;
import com.qf.repository.UserRepository;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository ur;
    @Override
    public Msg selectAll(int page, int pagerow) {
            if(page<0){
                page=0;
            }else {
                page=page-1;
            }
        PageRequest pr = PageRequest.of(page, pagerow);
        Page<User> all = ur.findAll(pr);
        List<User> content = all.getContent();
        long totalElements = all.getTotalElements();
        Msg msg=new Msg();
        msg.setList(content);
        msg.setAllrows(totalElements);
        return msg;
    }

    @Override
    public User selectOne(int id) {
        Optional<User> byId = ur.findById(id);
        User user =null;
        if(byId.isPresent()){
             user = byId.get();
        }
        return user;
    }

    @Override
    public String de(User user) {
        try{
            ur.deleteById(user.getUserid());
            return "yes";
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "no";
    }

    @Override
    public User up(User user) {
        return   ur.saveAndFlush(user);
    }
}
