package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.model.Plan;
import com.tencent.wxcloudrun.model.PlanTask;
import com.tencent.wxcloudrun.service.PlanService;
import com.tencent.wxcloudrun.service.PlanTaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/plan")
public class PlanController {

    @Autowired
    private PlanService planService;
    @Autowired
    private PlanTaskService planTaskService;

    @GetMapping("/{id}")
    public Plan get(@PathVariable String id) {
        return planService.get(id);
    }

    @GetMapping("/user/{userId}")
    public List<Map<String, Object>>  getByUserId(@PathVariable String userId) {
        List<Map<String, Object>> result = new ArrayList<>();
        
        List<Plan> list = planService.getByUserId(userId);
        for (Plan plan : list) {
            Map<String, Object> map = new HashMap<>();
            List<PlanTask> tasks = planTaskService.getByPlanId(plan.getId());
            Integer completedTasks = 0;
            for (PlanTask task : tasks) {
                if(task.getCompleted()==1) {
                    completedTasks++;
                }
            }
            map.put("id", plan.getId());
            map.put("title", plan.getTitle());
            map.put("deadline", plan.getDeadline().toString());
            map.put("createDate", plan.getCreatedAt().toString().substring(0,10));
            map.put("completedTasks", completedTasks.toString());
            map.put("tasks", tasks);
            result.add(map);
        }
        
        return result;
    }

    @PostMapping
    public void create(@RequestBody Plan plan) {
        UUID uuid = UUID.randomUUID();
        String uuid32 = uuid.toString().replace("-", "");
        plan.setId(uuid32);
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