package com.ssh.todos.todo.model;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class SearchModel {

    @Max(100)
    private Integer limit;
    private Integer skip;
}
