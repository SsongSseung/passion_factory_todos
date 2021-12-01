package com.ssh.todos.todo.service;

import com.ssh.todos.todo.mapper.TodoMapper;
import com.ssh.todos.todo.model.SearchModel;
import com.ssh.todos.todo.model.TodoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoMapper todoMapper;

    @Value("${apiKey}")
    private String apiKey;

    public List<TodoModel> getTodoList(SearchModel searchModel) {
        return todoMapper.getTodoList(searchModel);
    }

    public TodoModel insertTodo(TodoModel todoModel){
        todoMapper.insertTodo(todoModel);
        return todoMapper.getTodo(todoModel.getId());
    }

    public TodoModel getTodo(Integer id) {
        return todoMapper.getTodo(id);
    }

    public TodoModel updateTodo(Integer id, TodoModel todoModel) {
        todoModel.setId(id);
        todoMapper.updateTodo(todoModel);
        return todoMapper.getTodo(todoModel.getId());
    }

    public void deleteTodo(Integer id) {
        todoMapper.deleteTodo(id);
    }

    public Boolean chkApiKey(String apiKey){
        if(apiKey.equals(this.apiKey)){
            return true;
        }else{
            return false;
        }
    }

}
