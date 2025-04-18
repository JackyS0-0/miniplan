package com.tencent.wxcloudrun.model;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.List;

public class Plan {
    private String id;
    private String userId;
    private String parentplan;
    private String title;
    private Date deadline;
    private Integer status;
    private List<PlanTask> tasks;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getParentplan() {
        return parentplan;
    }

    public void setParentplan(String parentplan) {
        this.parentplan = parentplan;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<PlanTask> getTasks() {
        return tasks;
    }
    
    public void setTasks(List<PlanTask> tasks) {
        this.tasks = tasks;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}