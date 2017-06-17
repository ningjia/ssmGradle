package com.mytest.controller;

import com.mytest.pojo.User;
import com.mytest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by jn on 2017/5/16.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户列表
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/user/list")
    public String list(ModelMap modelMap) {
        //当前系统时间
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式
        String str_time = dateFormat.format( now );
        modelMap.put("serverTime", str_time );
        //获取用户列表
        Map<String, Object> list = userService.getUserList(null);
        modelMap.put("users", list );
        return "user/userList";
    }

    /**
     * 获取用户信息
     * @param id 用户id
     * @return json格式的用户信息
     */
    @RequestMapping(value = "/user/get", method = RequestMethod.GET)
    @ResponseBody
    //@ResponseBody注释用于将返回对象（User）变为响应的正文内容，将使用 MappingJacksonHttpMessageConverter将其映射到JSON。
    public User getUser(Integer id) {
        return userService.getUser(id);
    }

    /**
     * 更新用户信息
     * @param id 用户id
     * @return
     */
    @RequestMapping(value = "/user/update", method = RequestMethod.GET)
    @ResponseBody
    public String update(Integer id) {
        User user = userService.getUser(id);
        user.setName("更新+" + user.getName());
        if(user == null){
            return "用户不存在，userId=" + id;
        }
        userService.updateUser(user);
        return "用户更新成功，userId=" + id;
    }

    /**
     * （物理）删除用户
     * @param id 用户id
     * @return
     */
    @RequestMapping(value = "/user/delete", method = RequestMethod.GET)
    public String delete(Integer id) {
        userService.deleteUser(id);
        return "redirect:/user/list";
    }

    /**
     * 新增用户
     * @param u 用户对象
     * @return
     */
    @RequestMapping(value = "/user/add")
    public String add(User u) {
        userService.addUser(u);
        return "redirect:/user/list";
    }

}
