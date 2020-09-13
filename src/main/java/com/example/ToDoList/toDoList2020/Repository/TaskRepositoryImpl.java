package com.example.ToDoList.toDoList2020.Repository;

import com.example.ToDoList.toDoList2020.Model.Task;
import javassist.runtime.Desc;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.exception.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.xpendence.jooqexample.domain.tables.Tasks;
import ru.xpendence.jooqexample.domain.tables.records.TasksRecord;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TaskRepositoryImpl implements TaskReposirory<Task> {


    @Autowired
    private final DSLContext dslContext;


    @Override
    public void insert(Task task){
        dslContext
                .insertInto(Tasks.TASKS)
                .set(Tasks.TASKS.PRIORITY, task.getPriority())
                .set(Tasks.TASKS.DESCRIPTION, task.getDescription())
                .set(Tasks.TASKS.EXECUTOR, task.getExecutor())
                .execute();

    }

    @Override
    public void delete(Integer taskId) {
         dslContext
                 .deleteFrom(Tasks.TASKS)
                 .where(Tasks.TASKS.TASKID.eq(taskId))
                 .execute();
    }

    @Override
    public void upPriority(Integer taskId, Integer priority) {

        dslContext
                .update(Tasks.TASKS)
                .set(Tasks.TASKS.PRIORITY,priority + 1)
                .where(Tasks.TASKS.TASKID.eq(taskId))
                .execute();
    }

    @Override
    public void downPriority(Integer taskId, Integer priority) {

        dslContext
                .update(Tasks.TASKS)
                .set(Tasks.TASKS.PRIORITY,priority - 1)
                .where(Tasks.TASKS.TASKID.eq(taskId))
                .execute();
    }

    @Override
    public List<TasksRecord> findAll() {

        return dslContext
                .selectFrom(Tasks.TASKS)
                .orderBy(Tasks.TASKS.PRIORITY.desc())
                .fetch()
                .into(TasksRecord.class);

    }

    @Override
    public TasksRecord getPriority(Integer taskId) {
        return  dslContext
                .selectFrom(Tasks.TASKS)
                .where(Tasks.TASKS.TASKID.eq(taskId))
                .fetchAny()
                .into(TasksRecord.class)
        ;
    }


}

