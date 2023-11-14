package pl.edu.pwr.app;

import pl.edu.pwr.dbmanagement.ConnectionManager;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        ConnectionManager connectionManager = ConnectionManager.getInstance();
       connectionManager.getConnection();
        connectionManager.closeConnection();
    }
}