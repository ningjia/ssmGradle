package com.mytest.mapper;


import com.mytest.pojo.User;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
import java.util.Map;

/**
 * simplexwork mysql tools generate.
 * 用户表Mapper
 * 
 * @author
 * @date 
 * @tags
 */

public interface UserMapper {

	/**
	 * 查询列表
	 */
	public List<User> getUserList(Map<String, Object> params);

    /**
    * 查询列表总数
    */
    public int getUserCount(Map<String, Object> params);

	/**
	 * 查询数据
	 */
	public User getUser(int id);

	/**
	 * 添加数据
	 */
	public void addUser(User user);

	/**
	 * 更新数据
	 */
	public void updateUser(User user);

	/** 
	 * 删除数据
	 */
	public void deleteUser(int id);
	
}
