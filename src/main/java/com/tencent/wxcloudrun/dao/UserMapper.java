package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    User get(@Param("id") String id);

    User getByWxOpenId(@Param("wx_openid") String wx_openid);

    void create(User user);

    void update(User user);

    void delete(@Param("id") String id);
}