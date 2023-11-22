package pl.edu.pwr.service;

import pl.edu.pwr.model.Feedback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FeedbackController implements FeedbackService {

    private final Connection connection;

    public FeedbackController(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void editFeedback(Feedback feedback) {
        String sql = "UPDATE feedback SET  is_positive=?, weight=?, comment=? WHERE feedback_id=?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setBoolean(1, feedback.isPositive());
            statement.setInt(2, feedback.getWeight());
            statement.setString(3, feedback.getComment());
            statement.setInt(4, feedback.getOpinionID());


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
            statement.setString(2, String.valueOf(feedback.getDate()));
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

        if (deleteAll) {
            sql = "DELETE FROM feedback WHERE employee_id = ? ";
        } else {
            sql = "DELETE FROM feedback WHERE feedback_id = ? ";
        }

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0 && deleteAll) {
                System.out.println("Wszystkie opinie zostały usunięte");
            } else if (rowsAffected > 0 && !deleteAll) {
                System.out.println("Opinia została usunięta");
            } else {
                System.out.println("Blad podczas usuwania opinii");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Feedback> getFeedbackByTime(String timePeriod,int employeeId) {
        ArrayList<Feedback> feedbackList = new ArrayList<>();
        Boolean isResultSetEmpty = true;
        String sql = "SELECT * FROM feedback WHERE date BETWEEN DATE('now',?) AND DATE ('now') AND employee_id =?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, timePeriod);
            statement.setInt(2, employeeId);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                isResultSetEmpty = false;

                int opinionID = resultSet.getInt("feedback_id");
                Boolean isPositive = resultSet.getBoolean("is_positive");
                int weight = resultSet.getInt("weight");
                String comment = resultSet.getString("comment");

                feedbackList.add(new Feedback(opinionID, isPositive, weight, comment));
            }
            if (isResultSetEmpty) {
                feedbackList.add(new Feedback(0, false, 0, "NONE"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feedbackList;
    }
}
