package pl.edu.pwr.dbmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static ConnectionManager instance;
    private Connection connection;
    private static final String URL = "jdbc:sqlite:src/main/resources/database.db";
   // private static final String user = "server639277_empfb";
  //  private static final String password = "Admin123#";


    private ConnectionManager() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Nie mozna znalezc sterownika JDBC", e);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Blad podczas nawiazywania polaczenia z baza danych", e);
        }
    }

    public static ConnectionManager getInstance() {
        if (instance == null) {
            synchronized (ConnectionManager.class) {
                if (instance == null) {
                    instance = new ConnectionManager();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        System.out.println("Zamykam polaczenie z baza danych");
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Blad podczas zamykania polaczenia z baza danych", e);
        }
    }

}
