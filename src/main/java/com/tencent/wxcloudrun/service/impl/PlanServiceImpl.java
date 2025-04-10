package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.PlanMapper;
import com.tencent.wxcloudrun.model.Plan;
import com.tencent.wxcloudrun.service.PlanService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanMapper planMapper;

    @Override
    public Plan get(String id) {
        return planMapper.get(id);
    }
    
    @Override
    public List<Plan> getByUserId(String userId, Integer status) {
        return planMapper.getByUserId(userId,status);
    }

    @Override
    public void create(Plan plan) {
        planMapper.create(plan);
    }

    @Override
    public void update(Plan plan) {
        planMapper.update(plan);
    }

    @Override
    public void delete(String id) {
        planMapper.delete(id);
    }
}