package pl.edu.pwr.dbmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecordFinder {

    private final Connection connection;

    public RecordFinder() {
        this.connection = ConnectionManager.getInstance().getConnection();
    }

    public void findAllEmployeeOpinions(int employeeID) {
        boolean isResultSetEmpty = true;

        String sql = "SELECT feedback_id,comment FROM feedback where employee_id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, employeeID);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                isResultSetEmpty = false;

                String resultFeedbackID = resultSet.getString("feedback_id");
                String resultComment = resultSet.getString("comment");
                System.out.println("id: " + resultFeedbackID + " " + resultComment);
            }
            if (isResultSetEmpty) {
                System.out.println("Nie znalezono opinii dla podanego pracownika");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findClosestRecord(String userInput) {
        boolean isResultSetEmpty = true;

        String[] parts = userInput.split(",");
        String firstName = parts[0];
        String lastName = parts[1];

        String sql = "SELECT employee_id,first_name,last_name,email," +
                "abs(LENGTH(first_name) - LENGTH(?)) + abs(LENGTH(last_name) - LENGTH(?))" +
                "FROM employee WHERE first_name LIKE ? AND last_name LIKE ?" +
                "ORDER BY abs(LENGTH(first_name) - LENGTH(?)) + abs(LENGTH(last_name) - LENGTH(?))" +
                "LIMIT 3";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, "%" + firstName + "%");
            statement.setString(4, "%" + lastName + "%");
            statement.setString(5, firstName);
            statement.setString(6, lastName);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                isResultSetEmpty = false;

                int employeeId = resultSet.getInt("employee_id");
                String resultFirstName = resultSet.getString("first_name");
                String resultLastName = resultSet.getString("last_name");
                String resultEmail = resultSet.getString("email");

                System.out.println("id: " + employeeId + " " + resultFirstName + " " + resultLastName + " " + resultEmail);
            }
            if (isResultSetEmpty) {
                System.out.println("Nie znalezono takiego pracownika, aby kontynuować wpisz 0");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}