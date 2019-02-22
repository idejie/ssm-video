package com.grey.ssm.video.service.Impl;

//import com.grey.ssm.video.dao.AdminDao;
import com.grey.ssm.video.dao.MyDao;
import com.grey.ssm.video.model.User;
import com.grey.ssm.video.service.MyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MyDao myDao;


    public User getUserByID(int u_id) {
        return myDao.getUser(u_id);
    }
    public User getUserByName(String username){
        return myDao.getUserByName(username);
    }
    public void addUser(String username,String password){
        myDao.addUser(username,password);
    }
}
