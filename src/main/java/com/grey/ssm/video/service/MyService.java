package com.grey.ssm.video.service;


import com.grey.ssm.video.model.User;

public interface MyService {
    User getUserByID(int u_id);
    User getUserByName(String username);
    void addUser(String username,String password);
}
