package com.dyonestrankers.database.todolist.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabaseUtil {

    private static HikariDataSource hikariDataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setUsername("root");
        config.setPassword("root");
        config.setJdbcUrl("jdbc:mysql://localhost:3308/java_todolist_db3308?serverTimezone=Asia/Jakarta");

        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(60_000);
        config.setMaxLifetime(60*60*1000);

        hikariDataSource = new HikariDataSource(config);
    }

    public static HikariDataSource getDataSource(){
        return hikariDataSource;
    }

}
