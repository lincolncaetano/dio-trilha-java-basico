package br.com.lincolncaetano;


import br.com.lincolncaetano.persistence.migration.MigrationStrategy;
import br.com.lincolncaetano.ui.Menu;

import java.sql.SQLException;

import static br.com.lincolncaetano.persistence.config.ConnectionConfig.getConnection;

public class Main {
    public static void main(String[] args) throws SQLException {

        try(var connection = getConnection()){
            new MigrationStrategy(connection).executeMigration();
        }
        new Menu().execute();
    }
}