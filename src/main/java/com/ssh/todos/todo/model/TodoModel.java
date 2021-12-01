package com.ssh.todos.todo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.internal.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class TodoModel {
    @ApiModelProperty(hidden = true)
    private Integer id;
    private String name;
    private Boolean completed;

    @JsonFormat(pattern = "yyyy:MM:dd HH:mm:ss:SSS", timezone = "Asia/Seoul")
    @ApiModelProperty(hidden = true)
    private Date completedAt;
    @JsonFormat(pattern = "yyyy:MM:dd HH:mm:ss:SSS", timezone = "Asia/Seoul")
    @ApiModelProperty(hidden = true)
    private Date createdAt;
    @JsonFormat(pattern = "yyyy:MM:dd HH:mm:ss:SSS", timezone = "Asia/Seoul")
    @ApiModelProperty(hidden = true)
    private Date updatedAt;

}
