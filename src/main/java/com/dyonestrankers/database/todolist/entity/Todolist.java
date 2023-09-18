package com.dyonestrankers.database.todolist.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Todolist {
    private Integer id;
    private String todo;

    public Todolist(String todo) {
        this.todo = todo;
    }
}
