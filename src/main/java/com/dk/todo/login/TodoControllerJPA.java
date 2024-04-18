package com.dk.todo.login;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@SessionAttributes("name")
public class TodoControllerJPA 
{
    private TodoService service;
    private TodoRepository repository;

    public TodoControllerJPA(TodoService service, TodoRepository repository)
    {
        this.service = service;
        this.repository = repository;
    }

    @RequestMapping("todo")
    public String GetTodos(ModelMap model)
    {
        List<Todo> todos = repository.findByname(GetUserName());
        model.put("todos", todos);
        return "Todos";
    }

    @RequestMapping(value =  "addtodo", method = RequestMethod.GET)
    public String NewTask(ModelMap model)
    {
        Todo todo = new Todo(0, GetUserName(), "", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);

        return "Todo";
    }

    @RequestMapping(value =  "addtodo", method = RequestMethod.POST)
    public String AddTask(ModelMap model, @Valid Todo todo, BindingResult result)
    {
        if(result.hasErrors()) return "Todo";

        service.AddTodo(GetUserName(), todo.getDesc(), todo.getDateCompletion(), false);
        return "redirect:todo";
    }

    @RequestMapping("deletetodo")
    public String DeleteTodos(@RequestParam int id)
    {
        service.Delete(id);
        return "redirect:todo";
    }

    @RequestMapping(value = "updatetodo", method = RequestMethod.GET)
    public String UpdateTodosPage(@RequestParam int id, ModelMap model)
    {
        Todo todo = service.GetTodoById(id);
        model.addAttribute("todo", todo);

        return "Todo";
    }

    @RequestMapping(value = "updatetodo", method = RequestMethod.POST)
    public String UpdateTodos(ModelMap model, @Valid Todo todo, BindingResult result)
    {
        if(result.hasErrors()) return "Todo";
        
        todo.setName(GetUserName());
        service.Update(todo);
        return "redirect:todo";
    }


    private String GetUserName()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
