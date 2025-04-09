package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Plan;


public interface PlanService {

    Plan get(String id);

    void create(Plan plan);

    void update(Plan plan);

    void delete(String id);
}