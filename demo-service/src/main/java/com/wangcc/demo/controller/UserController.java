package com.wangcc.demo.controller;

import com.wangcc.demo.bo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: BryantCong
 * @Date: 2019/5/26 22:11
 * @Description:
 */
@RestController
@Slf4j
@RequestMapping("user")
public class UserController {

    @RequestMapping("detail")
    public User detail(@RequestBody User user){
        log.info("NAME:{}",user.getName());
        return user;
    }
}
