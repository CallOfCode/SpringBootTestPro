package com.example.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties({ConfigBean.class,User.class})
public class Controller2 {
    @Autowired
    ConfigBean configBean;
    @Autowired
    User user;
    @Value("${user.level}")
    String userLevel;

    @RequestMapping("/user2")
    public String user2(){
        return configBean.getGreeting()+">>"+configBean.getName()+">>"+configBean.getUuid();
    }

    @RequestMapping("/user3")
    public String user3(){
        return user.getName()+":"+user.getAge()+":"+userLevel;
    }

}
