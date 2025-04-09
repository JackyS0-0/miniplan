package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.PlanTask;
import java.util.List;


public interface PlanTaskService {

    PlanTask get(String id);

    List<PlanTask> getByPlanId(String planId);

    void create(PlanTask planTask);

    void update(PlanTask planTask);

    void delete(String id);
}