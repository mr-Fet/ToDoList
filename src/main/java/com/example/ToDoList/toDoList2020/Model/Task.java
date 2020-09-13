package com.example.ToDoList.toDoList2020.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@EqualsAndHashCode
@ToString
@Entity
@Table(name = "tasks", schema = "public")
@Data
public class Task {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer taskid;
    private Integer priority;
    private String description;
    private String executor;
}
