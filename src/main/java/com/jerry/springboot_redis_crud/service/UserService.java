package com.jerry.springboot_redis_crud.service;

import com.jerry.springboot_redis_crud.pojo.User;

public interface UserService {
    boolean addUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(int id);

    User findByUserId(int id);
}
