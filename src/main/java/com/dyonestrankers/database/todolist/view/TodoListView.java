package com.dyonestrankers.database.todolist.view;

import com.dyonestrankers.database.todolist.service.TodoListService;
import com.dyonestrankers.database.todolist.util.InputUtil;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TodoListView {

    private TodoListService todoListService;

    public void showTodoList(){
        while (true) {
            todoListService.showTodoList();

            System.out.println();
            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = InputUtil.input("Pilih");

            if (input.equals("1")) {
                addTodoList();
            } else if (input.equals("2")) {
                removeTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }

    public void addTodoList() {
        System.out.println();
        System.out.println("MENAMBAH TODOLIST");

        var todo = InputUtil.input("Todo (x Jika Batal)");

        if (todo.equals("x")) {
            System.out.println();
        } else {
            todoListService.addTodoList(todo);
        }
    }

    public void removeTodoList() {
        System.out.println();
        System.out.println("MENGHAPUS TODOLIST");

        var number = InputUtil.input("Nomor yang Dihapus (x Jika Batal)");

        if (number.equals("x")) {
            System.out.println();
        } else {
            todoListService.removeTodoList(Integer.valueOf(number));
        }
    }

}
