package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.PlanTask;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PlanTaskMapper {

    PlanTask get(@Param("id") String id);

    List<PlanTask> getByPlanId(@Param("planId") String planId);

    void create(PlanTask planTask);

    void update(PlanTask planTask);

    void delete(@Param("id") String id);
}