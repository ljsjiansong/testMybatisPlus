package com.example.testplus.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.testplus.entity.User;
import com.example.testplus.service.IUserOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserOperationService userOperationService;

    /**
     * 根据名称模糊查询
     *
     * @param name name
     * @return list
     */
    @GetMapping("/getListByName")
    public List<User> getUserInfoBySwapper(@RequestParam(value = "name",required = true)String name){
        return userOperationService.getUserBySwapper(name);
    }

    /**
     * 根据条件构造器分页查询
     *
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @param name name
     * @param age age
     * @return page
     */
    @GetMapping("/getListByPage")
    public IPage<User> getListByPage(@RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
                                     @RequestParam(value = "pageSize",defaultValue = "2")int pageSize,
                                     @RequestParam(value = "name",required = true)String name,
                                     @RequestParam(value = "age",required = true)int age){
        return userOperationService.getUserListPage(pageNum,pageSize,name,age);
    }


}
