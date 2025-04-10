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
    public Map<String, Object> get(@PathVariable String id) {
        Plan plan =  planService.get(id);
        Map<String, Object> map = new HashMap<>();
        map.put("id", plan.getId());
        map.put("title", plan.getTitle());
        map.put("deadline", plan.getDeadline().toString());
        List<PlanTask> tasks = planTaskService.getByPlanId(plan.getId());
        map.put("tasks", tasks);
        return map;
    }

    @GetMapping("/user/{userId}")
    public List<Map<String, Object>>  getByUserId(@PathVariable String userId,
    @RequestParam(required = false) Integer status) {
        List<Map<String, Object>> result = new ArrayList<>();
        
        List<Plan> list = planService.getByUserId(userId,status);
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
    public void savaPlan(@RequestBody Plan plan) {
        //更新plan
        planService.update(plan);
        //根据planid先删除所有task
        planTaskService.deleteByPlanId(plan.getId());
        //再添加task
        List<PlanTask> tasks = plan.getTasks();
        for(int index = 0;index<tasks.size();index++){ 
            PlanTask task = tasks.get(index);
            UUID uuid = UUID.randomUUID();
            String uuid32 = uuid.toString().replace("-", "");
            task.setId(uuid32);
            task.setPlanId(plan.getId());
            task.setIndex(index);
            planTaskService.create(task);
        }
    }

    @PutMapping("/status")
    public void changeStatus(@RequestBody Plan plan) {
        planService.changeStatus(plan);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        planService.delete(id);
        planTaskService.deleteByPlanId(id);
    }
}