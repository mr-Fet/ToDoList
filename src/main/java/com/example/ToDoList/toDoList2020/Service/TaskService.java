package com.example.ToDoList.toDoList2020.Service;

import com.example.ToDoList.toDoList2020.Model.Task;
import ru.xpendence.jooqexample.domain.tables.records.TasksRecord;

import java.util.List;

public interface TaskService {

    void addTask (Task task);
    void deleteTask (Integer taskId);
    void upPriority(Integer taskId, Integer priority);
    void downPriority(Integer taskId, Integer priority);
    List<TasksRecord> taskList();
    TasksRecord getPriority(Integer taskId);
}
