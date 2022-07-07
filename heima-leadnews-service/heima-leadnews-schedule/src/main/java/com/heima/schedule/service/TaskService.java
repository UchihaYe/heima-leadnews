package com.heima.schedule.service;

import com.heima.model.schedule.dtos.Task;

public interface TaskService {

    /**
     * 添加延时任务
     * @param task
     * @return
     */
    public long addTask(Task task);
}
