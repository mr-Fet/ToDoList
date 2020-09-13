package com.example.ToDoList.toDoList2020.Controller;

import com.example.ToDoList.toDoList2020.Model.Task;
import com.example.ToDoList.toDoList2020.Service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.xpendence.jooqexample.domain.tables.records.TasksRecord;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/TaskController")
public class TaskController {

    private final TaskService taskService;

    @RequestMapping(value = "/mainTaskMenu", method = RequestMethod.GET)
    public String mainTaskMenu(Model model){
        List<TasksRecord> list = taskService.taskList();
        model.addAttribute("allTask", list);
        model.addAttribute("newTask", new Task());
        //model.addAttribute("deleteBook", new Books());

        return "taskMenu";
    }

    @RequestMapping(value="/addTask", method= RequestMethod.POST)
    public ResponseEntity addTask(@ModelAttribute Task task){

            taskService.addTask(task);


        return  ResponseEntity.ok("Задача с приоритетом " + task.getPriority() + "<br>"
                + " описанием " + task.getDescription() + "<br>"
                + " исполнителем " + task.getExecutor() + " успешно создана");
    }

    @GetMapping(value="/deleteTask/{taskId}")
    public ResponseEntity deleteTask (@PathVariable Integer taskId){

            taskService.deleteTask(taskId);

        return  ResponseEntity.ok("Задача успешно удалена");
    }

    @GetMapping(value="/upPriority/{taskid}")
    public ResponseEntity upPriority (@PathVariable Integer taskid){

        Integer prior = taskService.getPriority(taskid).getPriority();

        if(prior.equals(10)){
            return ResponseEntity.ok("Приоритет 10 максимальный. Повысить невозможно.");
        }

        else {
            taskService.upPriority(taskid, prior);
        }
        return  ResponseEntity.ok("Приоритет повышен");
    }

    @GetMapping(value="/downPriority/{taskId}")
    public ResponseEntity downPriority (@PathVariable Integer taskId){
        Integer prior = taskService.getPriority(taskId).getPriority();

        if(prior.equals(1)){
            return ResponseEntity.ok("Приоритет 1 минимальный. Понизить невозможно.");
        }

        else {
            taskService.downPriority(taskId, prior);
        }
        return  ResponseEntity.ok("Приорите понижен");
    }

}
