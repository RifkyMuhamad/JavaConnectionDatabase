package com.dyonestrankers.database.todolist.repository;

import com.dyonestrankers.database.todolist.entity.Todolist;
import com.dyonestrankers.database.todolist.util.DatabaseUtil;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TodoListRepositoryImplTest {

    private HikariDataSource dataSource;

    private TodoListRepository repository;

    @BeforeEach
    void setUp() {
        dataSource = DatabaseUtil.getDataSource();
        repository = new TodoListRepositoryImpl(dataSource);
    }

    @Test
    @DisplayName("Test Add")
    void add() {
        Todolist todolist = new Todolist();
        todolist.setTodo("Dyone");

        repository.add(todolist);
    }

    @Test
    @DisplayName("Test Remove")
    void remove() {
        System.out.println(repository.remove(1));;
        System.out.println(repository.remove(2));;
        System.out.println(repository.remove(3));;
        System.out.println(repository.remove(4));;
    }

    @Test
    @DisplayName("Test Get All")
    void get() {
        List<Todolist> all = repository.getAll();
        for (Todolist todolist : all) {
            System.out.println(todolist.getId() + " : " + todolist.getTodo());
        }
    }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }
}
