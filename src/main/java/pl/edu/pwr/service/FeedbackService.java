package pl.edu.pwr.service;

import pl.edu.pwr.dbmanagement.ConnectionManager;
import pl.edu.pwr.dbmanagement.FeedbackDAO;
import pl.edu.pwr.model.Feedback;

import java.util.ArrayList;

public class FeedbackService implements FeedbackDAO {
    @Override
    public void addFeedback(Feedback feedback) {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        connectionManager.getConnection();





        connectionManager.closeConnection();
    }

    @Override
    public void cancelFeedback(int feedbackId) {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        connectionManager.getConnection();





        connectionManager.closeConnection();
    }

    @Override
    public ArrayList<Feedback> getTrendWeekly(int employeeId) {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        connectionManager.getConnection();





        connectionManager.closeConnection();
        return null;
    }

    @Override
    public ArrayList<Feedback> getTrendMonthly(int employeeId) {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        connectionManager.getConnection();





        connectionManager.closeConnection();
        return null;
    }

    @Override
    public ArrayList<Feedback> getTrendQuarterly(int employeeId) {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        connectionManager.getConnection();





        connectionManager.closeConnection();
        return null;
    }
}
