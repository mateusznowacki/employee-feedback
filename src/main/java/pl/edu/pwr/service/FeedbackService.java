package pl.edu.pwr.service;

import pl.edu.pwr.model.Feedback;

import java.util.ArrayList;

public interface FeedbackService {
    void addFeedback(Feedback feedback);

    void cancelFeedback(int feedbackId);

    ArrayList<Feedback> getTrendWeekly(int employeeId);

    ArrayList<Feedback> getTrendMonthly(int employeeId);

    ArrayList<Feedback> getTrendQuarterly(int employeeId);

}
