package com.example.testplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.testplus.entity.User;

import java.util.List;

public interface IUserOperationService {

    /**
     * 根据条件构造器查询集合数据
     *
     * @param name name
     * @return User
     */
    List<User> getUserBySwapper(String name);

    /**
     * 根据条件构造器分页查询
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @param name name
     * @param age age
     * @return page
     */
    IPage<User> getUserListPage(int pageNum,int pageSize,String name,int age);
}
