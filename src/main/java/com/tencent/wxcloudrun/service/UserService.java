package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.User;


public interface UserService {

    User get(String id);

    User getByWxOpenId(String wx_openid);

    void create(User user);

    void update(User user);

    void delete(String id);
}