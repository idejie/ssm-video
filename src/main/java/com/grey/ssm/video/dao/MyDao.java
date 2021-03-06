package com.grey.ssm.video.dao;

import com.grey.ssm.video.model.Resource;
import com.grey.ssm.video.model.User;
import com.grey.ssm.video.model.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MyDao {
    List<User> getAllUsers();
    User getUser(@Param("u_id") int u_id);
    User getUserByName(@Param("username")String username);
    void addUser(@Param("username") String username,@Param("password")String password);
    void updateUser(@Param("u_id") int u_id,@Param("username")String username,@Param("password")String password);
    void delUser(@Param("u_id")int u_id);
    void yesUser(@Param("u_id")int u_id);
    void noUser(@Param("u_id")int u_id);

    Video getVideo(@Param("v_id") int v_id);
    List<Video> getAllVideo(@Param("u_id") int u_id);
    void addVideo(@Param("u_id") int u_id,@Param("is_full") int is_full,@Param("location")String location,@Param("title")String title,@Param("descr")String descr);
    void updateVideo(@Param("v_id") int v_id,@Param("u_id") int u_id,@Param("is_full") int is_full,@Param("location")String location,@Param("title")String title,@Param("descr")String descr);
    void delVideo(@Param("v_id")int v_id);

    Resource getResource(@Param("r_id")int r_id);
    List<Resource> getMyRes(@Param("v_id")int v_id);
    void addRes(@Param("v_id") int v_id,@Param("pic_url") String pic_url,@Param("subtitle")String subtitle,@Param("duration")int duration);
    void updateRes(@Param("r_id") int r_id,@Param("v_id") int v_id,@Param("pic_url") int pic_url,@Param("subtitle")String subtitle,@Param("duration")int duration);
    void delRes(@Param("r_id")int r_id);


    void newVideo(@Param("u_id")int u_id);

    void addMusic(@Param("v_id")int v_id,@Param("filename") String filename);

    void finshVideo(int v_id);
}

