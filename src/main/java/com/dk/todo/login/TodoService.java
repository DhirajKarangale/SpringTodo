package com.dk.todo.login;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService 
{
    private static int cnt = 0;
    private static List<Todo> todos = new ArrayList<>();    

    static
    {
        todos.add(new Todo(++cnt, "DK", "Compete Trailer Old", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++cnt, "DK1", "Compete Trailer2 Old", LocalDate.now().plusYears(2), false));
        todos.add(new Todo(++cnt, "DK2", "Compete Trailer3 Old", LocalDate.now().plusYears(3), false));
    }
    
    public List<Todo> FindByName(String name)
    {
        java.util.function.Predicate<Todo> predicate = todo -> todo.getName().equalsIgnoreCase(name);
        return todos.stream().filter(predicate).toList();
    }

    public Todo GetTodoById(int id)
    {
        java.util.function.Predicate<Todo> predicate = todo -> todo.getId() == id;
        return todos.stream().filter(predicate).findFirst().get();
    }


    public void AddTodo(String name, String desc, LocalDate date, boolean isDone)
    {
        todos.add(new Todo(++cnt, name, desc, date, isDone));
    }

    public void Delete(int id)
    {
        java.util.function.Predicate<Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public void Update(Todo todo)
    {
        Delete(todo.getId());
        todos.add(todo);
    }
}