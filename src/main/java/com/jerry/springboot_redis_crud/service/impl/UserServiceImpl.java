package com.jerry.springboot_redis_crud.service.impl;

import com.jerry.springboot_redis_crud.dao.UserDao;
import com.jerry.springboot_redis_crud.pojo.User;
import com.jerry.springboot_redis_crud.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    private  final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean addUser(User user) {
        boolean flag=false;
        try{
            userDao.addUser(user);
            flag=true;
        }catch(Exception e){
            logger.error("新增失败!",e);
        }
        return flag;
    }

    @Override
    public boolean updateUser(User user) {
        boolean flag=false;
        try{
            userDao.updateUser(user);
            flag=true;
        }catch(Exception e){
            logger.error("修改失败!",e);
        }
        return flag;
    }

    @Override
    public boolean deleteUser(int id) {
        boolean flag=false;
        try{
            userDao.deleteUser(id);
            flag=true;
        }catch(Exception e){
            logger.error("删除失败!",e);
        }
        return flag;
    }


    @Override
    public User findByUserId(int id){
        return userDao.findByUserId(id);
    }
}
