package com.tencent.wxcloudrun.controller;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.tencent.wxcloudrun.service.UserService;
import com.tencent.wxcloudrun.model.User;
import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {

  @Autowired
  private UserService userService;

  @GetMapping("/login")
  public Map<String, String> login(@RequestHeader("X-WX-OPENID") String wx_openid) {
      User user = userService.getByWxOpenId(wx_openid);
      if(user == null ) {
          user = new User();
          user.setWxOpenid(wx_openid);
          UUID uuid = UUID.randomUUID();
          String uuid32 = uuid.toString().replace("-", "");
          user.setId(uuid32);
          user.setNickname("小计划用户");
          userService.create(user);
      }
      Map<String, String> map = new HashMap<>();
      map.put("id", user.getId());
      map.put("nickname", user.getNickname());
      map.put("avatarUrl", user.getAvatarUrl());
      return map;
  }


}
