package com.dyonestrankers.database.todolist.repository;

import com.dyonestrankers.database.todolist.entity.Todolist;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoListRepositoryImpl implements TodoListRepository{

    private DataSource dataSource;

    public TodoListRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Todolist> getAll() {
        String sql = "SELECT id, todo FROM todolist";
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){

            List<Todolist> list = new ArrayList<>();

            while (resultSet.next()) {
                Todolist todolist = new Todolist();
                todolist.setId(resultSet.getInt("id"));
                todolist.setTodo(resultSet.getString("todo"));

                list.add(todolist);
            }

            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Todolist todolist) {
        String sql = "INSERT INTO todolist(todo) VALUES (?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, todolist.getTodo());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isExist(Integer number){
        String sql = "SELECT id FROM todolist WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, number);
            try (ResultSet resultSet = statement.executeQuery()){
                if (resultSet.next()){
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean remove(Integer number) {

        if (isExist(number)){
            String sql = "DELETE FROM todolist WHERE id = ?";

            try (Connection connection = dataSource.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1, number);
                statement.executeUpdate();

                return true;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            return false;
        }

    }
}
