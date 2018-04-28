package com.example.demo.resource;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.service.impl.ILoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author yaoyang
 * @Description:
 * @date 2018/4/28
 */
@RestController
@Api(description = "登陆接口")
public class LoginResource {
    @Autowired
    private ILoginService loginService;

    //退出的时候是get请求，主要是用于退出
    @GetMapping(value = "/login")
    @ApiOperation(value = "get登录")
    public String login(){
        return "login";
    }

    //post登录
    @PostMapping(value = "/login")
    @ApiOperation(value = "post登录")
    public String login(@RequestBody Map map){
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                map.get("username").toString(),
                map.get("password").toString());
        //进行验证，这里可以捕获异常，然后返回对应信息
        subject.login(usernamePasswordToken);
        return "login";
    }

    @GetMapping(value = "/index")
    public String index(){
        return "index";
    }

    //登出
    @PostMapping(value = "/logout")
    public String logout(){
        return "logout";
    }

    //错误页面展示
    @PostMapping(value = "/error")
    public String error(){
        return "error ok!";
    }

    //数据初始化
    @PostMapping(value = "/addUser")
    @ApiOperation(value = "用户初始化")
    public String addUser(@RequestBody Map<String,Object> map){
        User user = loginService.addUser(map);
        return "addUser is ok! \n" + user;
    }

    //角色初始化
    @PostMapping(value = "/addRole")
    @ApiOperation(value = "角色初始化")
    public String addRole(@RequestBody Map<String,Object> map){
        Role role = loginService.addRole(map);
        return "addRole is ok! \n" + role;
    }

    //注解的使用
    @RequiresRoles("admin")
    @RequiresPermissions("create")
    @PostMapping(value = "/create")
    public String create(){
        return "Create success!";
    }
}
