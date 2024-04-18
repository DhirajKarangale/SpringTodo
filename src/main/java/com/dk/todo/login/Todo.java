package com.dk.todo.login;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Todo 
{
    @Id
    @GeneratedValue
    public int id;
    
    @Size(min = 5, message = "Enter least 5 characters")    
    public String desc;

    public String name;
    public boolean isDone;
    public LocalDate dateCompletion;
    
    public Todo()
    {

    }

    public Todo(int id, String name, String desc, LocalDate dateCompletion, boolean isDone) 
    {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.isDone = isDone;
        this.dateCompletion = dateCompletion;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public void setDesc(String desc) 
    {
        this.desc = desc;
    }

    public void setDone(boolean isDone) 
    {
        this.isDone = isDone;
    }

    public void setDateCompletion(LocalDate dateCompletion) 
    {
        this.dateCompletion = dateCompletion;
    }

    public int getId() 
    {
        return id;
    }

    public String getName() 
    {
        return name;
    }

    public String getDesc() 
    {
        return desc;
    }

    public boolean getIsDone() 
    {
        return isDone;
    }

    public LocalDate getDateCompletion() 
    {
        return dateCompletion;
    }

    @Override
    public String toString() {
        return "Home [id=" + id + ", name=" + name + ", desc=" + desc + ", isDone=" + isDone + ", dateCompletion="
                + dateCompletion + "]";
    } 
}