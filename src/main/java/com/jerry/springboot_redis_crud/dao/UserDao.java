package com.jerry.springboot_redis_crud.dao;

import com.jerry.springboot_redis_crud.pojo.User;

public interface UserDao {
    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

    User findByUserId(int id);
}
