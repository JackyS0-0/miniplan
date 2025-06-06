package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Plan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface PlanMapper {

    Plan get(@Param("id") String id);

    List<Plan> getByUserId(@Param("userId") String userId,
                          @Param("status") Integer status);

    void create(Plan plan);

    void update(Plan plan);

    void changeStatus(Plan plan);

    void delete(@Param("id") String id);
}