package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Plan;
import java.util.List;


public interface PlanService {

    Plan get(String id);

    List<Plan> getByUserId(String userId, Integer status);

    void create(Plan plan);

    void update(Plan plan);

    void changeStatus(Plan plan);

    void delete(String id);
}