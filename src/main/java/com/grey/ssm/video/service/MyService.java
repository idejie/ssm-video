package com.grey.ssm.video.service;


import com.grey.ssm.video.model.Resource;
import com.grey.ssm.video.model.User;
import com.grey.ssm.video.model.Video;

import java.util.List;

public interface MyService {
    User getUserByID(int u_id);
    User getUserByName(String username);
    void addUser(String username,String password);
    List<User> getAllUsers();

    void delUser(int id);

    void yesUser(int id);

    void noUser(int id);

    List<Video> getUserVideo(int u_id);

    void delVideo(int id);

    Video getVideo(int id);

    void newVideo(int id);

    List<Resource> getRes(int v_id);

    void addRes(int v_id, String pic, String subtitle, int d);

    void addMusic(int v_id, String filename);

    void finishVideo(int v_id);

    Resource getARes(int r_id);

    void delRes(int r_id);
}
