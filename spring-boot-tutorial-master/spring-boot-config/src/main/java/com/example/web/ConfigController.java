package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.ConfigBean;
import com.example.bean.User;


@RestController
//@EnableConfigurationProperties({ConfigBean.class,User.class})
public class ConfigController {
    @Autowired
    ConfigBean configBean;

    @RequestMapping(value = "/config")
    public String config(){
    	return configBean.toString();
    }

    @Autowired
    User user;
    
    @RequestMapping(value = "/user")
    public String user(){
        return user.getName()+user.getAge();
    }

}
