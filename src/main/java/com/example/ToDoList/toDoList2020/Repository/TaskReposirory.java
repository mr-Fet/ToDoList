package com.example.ToDoList.toDoList2020.Repository;

import com.example.ToDoList.toDoList2020.Model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.xpendence.jooqexample.domain.tables.records.TasksRecord;

import java.util.List;


public interface TaskReposirory<T>  {
    void insert(T t);
    void delete(Integer taskId);
    void upPriority(Integer taskId, Integer priority);
    void downPriority(Integer taskId, Integer priority);
    List<TasksRecord> findAll();
    TasksRecord getPriority(Integer taskId);

}
