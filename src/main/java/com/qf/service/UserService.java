package com.qf.service;

import com.qf.pojo.Msg;
import com.qf.pojo.User;

import java.util.List;

public interface UserService {
    public Msg selectAll(int page, int pagerow);
    public  User selectOne(int id);
    public  String de(User user);
    public  User up(User user );
}
