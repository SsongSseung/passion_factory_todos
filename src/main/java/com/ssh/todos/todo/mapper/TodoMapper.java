package com.ssh.todos.todo.mapper;

import com.ssh.todos.todo.model.SearchModel;
import com.ssh.todos.todo.model.TodoModel;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TodoMapper {
    List<TodoModel> getTodoList(SearchModel searchModel);

    TodoModel getTodo(Integer id);

    Integer insertTodo(TodoModel todoModel);

    void updateTodo(TodoModel todoModel);

    void deleteTodo(Integer id);
}
