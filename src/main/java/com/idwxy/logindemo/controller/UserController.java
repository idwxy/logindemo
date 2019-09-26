package com.idwxy.logindemo.controller;

import com.idwxy.logindemo.common.ResultObject;
import com.idwxy.logindemo.entity.User;
import com.idwxy.logindemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 登录
    @PostMapping("/login")
    public ResultObject login(@RequestBody User user) {
        if (user == null) {
            return new ResultObject(406, "登录失败",null);
        }
        ResultObject resultObject = userService.login(user);
        return resultObject;
    }

    // 测试单点登录
    @GetMapping("/test")
    public ResultObject test() {
        ResultObject resultObject = new ResultObject(200,"测试登录成功", null);
        return resultObject;
    }

    // 注销
    @GetMapping("/logout")
    public ResultObject logout(@RequestParam String token) {
        ResultObject resultObject = userService.logout(token);
        return resultObject;
    }
}
