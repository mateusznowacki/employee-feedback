package pl.edu.pwr.service;

import pl.edu.pwr.model.Feedback;

import java.sql.Connection;
import java.util.ArrayList;

public class FeedbackController implements FeedbackService {

    private Connection connection;

    public FeedbackController(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addFeedback(Feedback feedback) {

    }

    @Override
    public void cancelFeedback(int feedbackId) {

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
