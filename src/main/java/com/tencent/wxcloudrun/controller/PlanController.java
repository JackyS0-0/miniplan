package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.model.Plan;
import com.tencent.wxcloudrun.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/plan")
public class PlanController {

    @Autowired
    private PlanService planService;

    @GetMapping("/{id}")
    public Plan get(@PathVariable String id) {
        return planService.get(id);
    }

    @GetMapping("/user/{userId}")
    public List<Plan> getByUserId(@PathVariable String userId) {
        return planService.getByUserId(userId);
    }

    @PostMapping
    public void create(@RequestBody Plan plan) {
        planService.create(plan);
    }

    @PutMapping
    public void update(@RequestBody Plan plan) {
        planService.update(plan);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        planService.delete(id);
    }
}