package com.idwxy.logindemo.service.impl;

import com.idwxy.logindemo.common.ResultObject;
import com.idwxy.logindemo.dao.UserDao;
import com.idwxy.logindemo.entity.User;
import com.idwxy.logindemo.service.UserService;
import com.idwxy.logindemo.util.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Resource
    private RedisUtil redisUtil;

    // 登录
    @Override
    public ResultObject login(User user) {
        ResultObject resultObject = new ResultObject();
        // 查询用户账户、密码是否正确
        User fullUser = userDao.select(user);
        // 不正确直接返回
        if (fullUser == null) {
            resultObject.setCode(-1);
            resultObject.setMsg("用户名或密码错误");
            return resultObject;
        }
        // 生成随机 token
        String token = UUID.randomUUID().toString();
        int interval = 60 * 5;
        // 将用户的 token 作为 key，用户信息作为 value
        redisUtil.set(token, fullUser, interval);
        // 防止同一个账户多人登录
        redisUtil.set(Integer.toString(fullUser.getId()), token, interval);
        resultObject.setCode(200);
        resultObject.setMsg("登录成功");
        Map<String, Object> map = new HashMap<>();
        map.put("token", fullUser);
        fullUser.setPassword(null);
        map.put("user", fullUser);
        resultObject.setResult(map);
        return resultObject;
    }

    // 注销
    @Override
    public ResultObject logout(String token) {
        User user = (User)redisUtil.get(token);
        redisUtil.del(Integer.toString(user.getId()));
        redisUtil.del(token);
        return new ResultObject(200, "注销成功", null);
    }
}
