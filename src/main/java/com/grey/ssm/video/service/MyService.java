package com.grey.ssm.video.service;


import com.grey.ssm.video.model.User;

import java.util.List;

public interface MyService {
    User getUserByID(int u_id);
    User getUserByName(String username);
    void addUser(String username,String password);
    List<User> getAllUsers();

    void delUser(int id);

    void yesUser(int id);

    void noUser(int id);
}
