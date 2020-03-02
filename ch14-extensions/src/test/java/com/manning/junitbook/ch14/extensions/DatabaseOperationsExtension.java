package com.manning.junitbook.ch14.extensions;

import com.manning.junitbook.ch14.jdbc.TablesManager;
import org.junit.jupiter.api.extension.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;

import com.manning.junitbook.ch14.jdbc.ConnectionManager;

public class DatabaseOperationsExtension implements BeforeAllCallback, AfterAllCallback, BeforeEachCallback, AfterEachCallback {

    private Connection connection;
    private Savepoint savepoint;

    @Override
    public void beforeAll(ExtensionContext context) {
        connection = ConnectionManager.openConnection();
        TablesManager.dropTable(connection);
        TablesManager.createTable(connection);
    }

    @Override
    public void afterAll(ExtensionContext context) {
        ConnectionManager.closeConnection();
    }

    @Override
    public void beforeEach(ExtensionContext context) throws SQLException {
        connection.setAutoCommit(false);
        savepoint = connection.setSavepoint("savepoint");
    }

    @Override
    public void afterEach(ExtensionContext context) throws SQLException {
        connection.rollback(savepoint);
    }


}
