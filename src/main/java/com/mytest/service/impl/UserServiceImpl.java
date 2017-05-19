package com.mytest.service.impl;

import com.mytest.mapper.UserMapper;
import com.mytest.pojo.User;
import com.mytest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jn on 2017/5/16.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User addUser(User user) {
        if (user == null) {
            throw new NullPointerException();
        }
        userMapper.addUser(user);
        return user;
    }

    @Override
    public void updateUser(User user) {
        if (user == null) {
            throw new NullPointerException();
        }
        if (user.getId() == null) {
            throw new IllegalArgumentException("Missing argument id ");
        }
        userMapper.updateUser(user);
    }

    @Override
    public User getUser(int id) {
        return userMapper.getUser(id);
    }

    @Override
    public Map<String, Object> getUserList(Map<String, Object> params) {
        Map<String, Object> result = new HashMap<String, Object>();

        if (params == null) {
            params = new HashMap<String, Object>();
            params.put("offset", 0);
            params.put("limit", 10);
        }

        if (params.get("offset") == null) {
            throw new IllegalArgumentException("Invalid argument offset");
        }

        if (params.get("limit") == null) {
            throw new IllegalArgumentException("Invalid argument limit");
        }

        result.put("count", userMapper.getUserCount(params));
        result.put("list", userMapper.getUserList(params));

        return result;
    }

    @Override
    public void deleteUser(int id) {
        userMapper.deleteUser(id);
    }
}
