package pl.edu.pwr.service;

import pl.edu.pwr.model.Feedback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class FeedbackController implements FeedbackService {

    private Connection connection;

    public FeedbackController(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void editFeedback(int feedbackID) {
        String sql = "UPDATE feedback SET  is_positive=?, weight=?, comment=? WHERE feedback_id";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {



        int rowsAffected = statement.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Feedback został zaktualizowany");
        } else {
            System.out.println("Nie zaktualizowano feedbacku");
        }
     } catch (SQLException e) {
        e.printStackTrace();
    }
}

    @Override
    public void addFeedback(Feedback feedback) {

        String sqlInsertFeedback = "INSERT INTO feedback (employee_id, date, is_positive, weight, comment) VALUES (?,?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sqlInsertFeedback)) {
            statement.setInt(1, feedback.getEmployeeID());
            statement.setDate(2, feedback.getDate());
            statement.setBoolean(3, feedback.isPositive());
            statement.setInt(4, feedback.getWeight());
            statement.setString(5, feedback.getComment());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Opinia dodana");
            } else {
                System.out.println("Błąd podczas dodawania opinii");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFeedback(int id, boolean deleteAll) {
        String sql;

        if (deleteAll == true) {
            sql = "DELETE FROM feedback WHERE employee_id = ? ";
        } else {
            sql = "DELETE FROM feedback WHERE feedback_id = ? ";
        }

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0 && deleteAll == true) {
                System.out.println("Wszystkie opinie zostały usunięte");
            } else if (rowsAffected > 0 && deleteAll == false) {
                System.out.println("Opinia została usunięta");
            } else {
                System.out.println("Blad podczas usuwania opinii");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Feedback> getTrendWeekly(int employeeId) {
        return null;
    }

    @Override
    public ArrayList<Feedback> getTrendMonthly(int employeeId) {
        return null;
    }

    @Override
    public ArrayList<Feedback> getTrendQuarterly(int employeeId) {
        return null;
    }
}
