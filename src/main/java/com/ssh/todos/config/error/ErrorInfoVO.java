package com.ssh.todos.config.error;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonPropertyOrder({"code", "message"})
@SuppressWarnings("serial")
public class ErrorInfoVO implements Serializable {
    private String status;
    private String error;
}
