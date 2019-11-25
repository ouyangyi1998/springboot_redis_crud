package com.jerry.springboot_redis_crud.web;

import com.jerry.springboot_redis_crud.pojo.User;
import com.jerry.springboot_redis_crud.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserRestController {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public boolean addUser(@RequestBody User user)
    {
        logger.info("开始新增");
        return userService.addUser(user);
    }
    @PutMapping("/user")
    public boolean updateUser(@RequestBody User user) {
        logger.info("开始更新...");
        return userService.updateUser(user);
    }

    @DeleteMapping("/user")
    public boolean delete(@RequestParam(value = "id", required = true) int userId) {
        logger.info("开始删除...");
        return userService.deleteUser(userId);
    }

    @GetMapping("/user")
    public User findByUserId(@RequestParam(value = "id", required = true) int userId){
        logger.info("开始查询所有数据...");
        return userService.findByUserId(userId);
    }

}
