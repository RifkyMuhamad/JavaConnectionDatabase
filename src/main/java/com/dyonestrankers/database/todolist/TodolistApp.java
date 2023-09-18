package com.dyonestrankers.database.todolist;

import com.dyonestrankers.database.todolist.repository.*;
import com.dyonestrankers.database.todolist.service.*;
import com.dyonestrankers.database.todolist.util.DatabaseUtil;
import com.dyonestrankers.database.todolist.view.TodoListView;

import javax.sql.DataSource;

public class TodolistApp {
    public static void main(String[] args) {
        DataSource dataSource = DatabaseUtil.getDataSource();
        TodoListRepository todoListRepository = new TodoListRepositoryImpl(dataSource);
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListView.showTodoList();
    }
}
