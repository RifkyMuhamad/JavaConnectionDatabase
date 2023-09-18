package com.dyonestrankers.database.todolist.service;

import lombok.AllArgsConstructor;

import com.dyonestrankers.database.todolist.entity.Todolist;
import com.dyonestrankers.database.todolist.repository.TodoListRepository;

import java.util.List;

@AllArgsConstructor
public class TodoListServiceImpl implements TodoListService{

    private TodoListRepository todoListRepository;

    @Override
    public void showTodoList() {
        List<Todolist> model = todoListRepository.getAll();

        System.out.println("TODOLIST");
        for (Todolist todolist : model) {
            System.out.println(todolist.getId() + ". " + todolist.getTodo());
        }
    }

    @Override
    public void addTodoList(String todo) {
        Todolist todolist = new Todolist(todo);
        todoListRepository.add(todolist);
        System.out.println();
        System.out.println("SUKSES MENAMBAH TODO : " + todo);
        System.out.println();
    }

    @Override
    public void removeTodoList(Integer number) {
        boolean success = todoListRepository.remove(number);
        if (success) {
            System.out.println();
            System.out.println("SUKSES MENGHAPUS TODO : " + number);
            System.out.println();
        } else {
            System.out.println();
            System.out.println("GAGAL MENGHAPUS TODO : " + number);
            System.out.println();
        }
    }
}
