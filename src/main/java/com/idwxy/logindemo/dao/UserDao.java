package com.idwxy.logindemo.dao;

import com.idwxy.logindemo.entity.User;

public interface UserDao {

    /**
     * 查询用户
     * @param user
     * @return
     */
    User select(User user);
}
