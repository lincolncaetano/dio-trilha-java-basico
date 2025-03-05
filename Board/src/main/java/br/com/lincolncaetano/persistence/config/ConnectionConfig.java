package br.com.lincolncaetano.persistence.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ConnectionConfig {

    public static Connection getConnection() throws SQLException {
        var connection = DriverManager.getConnection("jdbc:mysql://localhost/board", "root", "root");
        connection.setAutoCommit(false);
        return connection;
    }

}
