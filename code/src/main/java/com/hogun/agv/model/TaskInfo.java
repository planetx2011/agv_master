package com.hogun.agv.model;

import java.sql.Date;

public class TaskInfo {
    private int Agv_id;
    private String taskName;  //任务名称
    private String taskDescript;    //任务描述
    private String endTime; //完成时间

    public int getAgv_id() {
        return Agv_id;
    }

    public void setAgv_id(int agv_id) {
        Agv_id = agv_id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescript() {
        return taskDescript;
    }

    public void setTaskDescript(String taskDescript) {
        this.taskDescript = taskDescript;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
