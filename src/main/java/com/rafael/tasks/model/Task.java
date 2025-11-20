package com.rafael.tasks.model;
public class Task {
    private String title;
    private String description;
    private Priority priority;
    private Status status;
    public Task(String title, String description, Priority priority) {
        if (title == null || title.isBlank()) throw new IllegalArgumentException("El título no puede estar vacío");
        this.title = title; this.description = description; this.priority = priority; this.status = Status.PENDING;
    }
    public String getTitle(){return title;}
    public String getDescription(){return description;}
    public Priority getPriority(){return priority;}
    public Status getStatus(){return status;}
    public void setPriority(Priority newPriority){
        if(status==Status.DONE) throw new IllegalStateException("No se puede cambiar prioridad de una tarea finalizada");
        this.priority=newPriority;
    }
    public void setStatus(Status newStatus){
        if(newStatus==Status.DONE && status!=Status.IN_PROGRESS) throw new IllegalStateException("Para finalizar debe estar IN_PROGRESS");
        this.status=newStatus;
    }
}