package com.ssh.todos.todo.controller;

import com.ssh.todos.config.error.ForbiddenException;
import com.ssh.todos.config.error.NotFoundException;
import com.ssh.todos.todo.model.SearchModel;
import com.ssh.todos.todo.service.TodoService;
import com.ssh.todos.todo.model.TodoModel;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@Validated
@RequestMapping("/todos")
public class TodoController {


    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<TodoModel> getTodoList(@RequestParam(required = false) Integer limit, @RequestParam(required = false) Integer skip ){
        SearchModel searchModel = new SearchModel();
        searchModel.setLimit(limit);
        searchModel.setSkip(skip);
        return todoService.getTodoList(searchModel);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public TodoModel getTodo(@PathVariable Integer id){
        TodoModel result = todoService.getTodo(id);
        if(result == null) throw new NotFoundException();

        return todoService.getTodo(id);
    }



    @RequestMapping(value = "",method = RequestMethod.POST)
    public TodoModel createTodo(@RequestParam String apiKey, @RequestBody  TodoModel todoModel){
        if(!todoService.chkApiKey(apiKey)) throw new ForbiddenException();

        return todoService.insertTodo(todoModel);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public TodoModel updateTodo(@RequestParam String apiKey,@PathVariable Integer id,@RequestBody  TodoModel todoModel){
        if(!todoService.chkApiKey(apiKey)) throw new ForbiddenException();
        if(todoService.getTodo(id) == null) throw new NotFoundException();
        return todoService.updateTodo(id,todoModel);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteTodo(@RequestParam String apiKey, @PathVariable Integer id){
        if(!todoService.chkApiKey(apiKey)) throw new ForbiddenException();
        if(todoService.getTodo(id) == null) throw new NotFoundException();
        todoService.deleteTodo(id);
    }



}
