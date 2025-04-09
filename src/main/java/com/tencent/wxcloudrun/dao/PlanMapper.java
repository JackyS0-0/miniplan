package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Plan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PlanMapper {

    Plan get(@Param("id") String id);

    void create(Plan plan);

    void update(Plan plan);

    void delete(@Param("id") String id);
}