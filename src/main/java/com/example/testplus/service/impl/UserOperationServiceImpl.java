package com.example.testplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.testplus.entity.User;
import com.example.testplus.mapper.UserMapper;
import com.example.testplus.service.IUserOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOperationServiceImpl implements IUserOperationService {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserBySwapper(String name){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name",name);
        return userMapper.selectList(wrapper);
    }

    @Override
    public IPage<User> getUserListPage(int pageNum,int pageSize,String name,int age) {
        IPage<User> page = new Page<>(pageNum,pageSize);
        // 设置查询条件
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name",name);
        // 大于等于
        wrapper.ge("age",age);
        return userMapper.selectPage(page,wrapper);
    }
}
