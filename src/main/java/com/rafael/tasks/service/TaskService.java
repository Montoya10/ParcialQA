package com.rafael.tasks.service;
import com.rafael.tasks.model.*;
import java.util.*;
import java.util.stream.Collectors;
public class TaskService {
    private final List<Task> tasks = new ArrayList<>();
    public Task createTask(String title,String description,Priority priority){
        Task t=new Task(title,description,priority);
        tasks.add(t);
        return t;
    }
    public List<Task> findByStatus(Status status){
        return tasks.stream().filter(t->t.getStatus()==status).collect(Collectors.toList());
    }
    public List<Task> findByPriority(Priority priority){
        return tasks.stream().filter(t->t.getPriority()==priority).collect(Collectors.toList());
    }
}