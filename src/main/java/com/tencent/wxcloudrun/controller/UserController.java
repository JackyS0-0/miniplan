package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.model.User;
import com.tencent.wxcloudrun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public Map<String,String> get(@PathVariable String id) {
        Map<String,String> map = new HashMap<>();
        User user = userService.get(id);
        map.put("nickname", user.getNickname());
        map.put("avatar", user.getAvatarUrl());
        return map;
    }

    @PostMapping
    public void create(@RequestBody User user) {
        userService.create(user);
    }

   
}