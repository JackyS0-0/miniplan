package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.model.PlanTask;
import com.tencent.wxcloudrun.service.PlanTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/task")
public class PlanTaskController {

    @Autowired
    private PlanTaskService planTaskService;

    @GetMapping("/{id}")
    public PlanTask get(@PathVariable String id) {
        return planTaskService.get(id);
    }

    @GetMapping("/plan/{planId}")
    public List<PlanTask> getByPlanId(@PathVariable String planId) {
        return planTaskService.getByPlanId(planId);
    }

    @PostMapping
    public void create(@RequestBody PlanTask planTask) {
        planTaskService.create(planTask);
    }

    @PutMapping
    public void completed(@RequestBody PlanTask planTask) {
        planTaskService.changeCompleted(planTask);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        planTaskService.delete(id);
    }
}