package com.dyonestrankers.database.todolist.repository;

import com.dyonestrankers.database.todolist.entity.Todolist;

import java.util.List;

public interface TodoListRepository {

    List<Todolist> getAll();

    void add(Todolist todolist);

    boolean remove(Integer number);

}
