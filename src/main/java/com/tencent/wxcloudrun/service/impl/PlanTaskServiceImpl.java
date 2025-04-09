package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.PlanTaskMapper;
import com.tencent.wxcloudrun.model.PlanTask;
import com.tencent.wxcloudrun.service.PlanTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class PlanTaskServiceImpl implements PlanTaskService {

    @Autowired
    private PlanTaskMapper planTaskMapper;

    @Override
    public PlanTask get(String id) {
        return planTaskMapper.get(id);
    }

    @Override
    public List<PlanTask> getByPlanId(String planId) {
        return planTaskMapper.getByPlanId(planId);
    }

    @Override
    public void create(PlanTask planTask) {
        planTaskMapper.create(planTask);
    }

    @Override
    public void update(PlanTask planTask) {
        planTaskMapper.update(planTask);
    }

    @Override
    public void delete(String id) {
        planTaskMapper.delete(id);
    }
}