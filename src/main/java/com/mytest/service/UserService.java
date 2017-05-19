package com.mytest.service;

import com.mytest.pojo.User;

import java.util.Map;

/**
 * Created by jn on 2017/5/16.
 */
public interface UserService {

    /**
     * 添加用户表
     * @param user 用户表()
     * @return 用户表
     */
    public User addUser(User user);

    /**
     * 更新用户表
     * @param user 用户表( id 必须 |)
     */
    public  void updateUser(User user);

    /**
     * 查询用户表
     *
     * @return 用户表
     */
    public User getUser(int id);

    /**
     * 查询用户表列表
     *
     * @param params
     *            查询条件
     *            <ul>
     *            <li>name:用户名</li>
     *            <li>password:密码</li>
     *            </ul>
     * @return Map
     *         <ul>
     *         <li>count:用户表数量</li>
     *         <li>list:用户表列表</li>
     *         </ul>
     */
    public Map<String, Object> getUserList(Map<String, Object> params);

    /**
     * 删除数据
     */
    public void deleteUser(int id);
}
