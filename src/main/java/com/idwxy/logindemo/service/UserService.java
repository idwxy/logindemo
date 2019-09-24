package com.idwxy.logindemo.service;

import com.idwxy.logindemo.common.ResultObject;
import com.idwxy.logindemo.entity.User;

public interface UserService {

    /**
     * 登录
     * @param user
     * @return
     */
    ResultObject login(User user);

    /**
     * 注销
     * @param token
     * @return
     */
    ResultObject logout(String token);
}
