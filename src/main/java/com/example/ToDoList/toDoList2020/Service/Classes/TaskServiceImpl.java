package com.example.ToDoList.toDoList2020.Service.Classes;

import com.example.ToDoList.toDoList2020.Model.Task;
import com.example.ToDoList.toDoList2020.Repository.TaskReposirory;
import com.example.ToDoList.toDoList2020.Service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.xpendence.jooqexample.domain.tables.records.TasksRecord;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskReposirory<Task> taskRepository;


    @Override
    public void addTask(Task task) {
        taskRepository.insert(task);
    }

    @Override
    public void deleteTask(Integer taskId) {
        taskRepository.delete(taskId);
    }

    @Override
    public void upPriority(Integer taskId, Integer priority) {
        taskRepository.upPriority(taskId, priority);
    }

    @Override
    public void downPriority(Integer taskId, Integer priority) {
        taskRepository.downPriority(taskId, priority);
    }

    @Override
    public List<TasksRecord> taskList() {

        return taskRepository.findAll();
    }

    @Override
    public TasksRecord getPriority(Integer taskId) {
        return taskRepository.getPriority(taskId);
    }

}
