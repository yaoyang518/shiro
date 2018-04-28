package com.example.demo.service.impl;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;

import java.util.Map;

/**
 * @author yaoyang
 * @Description:
 * @date 2018/4/28
 */
public interface ILoginService {

    User addUser(Map<String, Object> map);

    Role addRole(Map<String, Object> map);

    User findByName(String name);
}
