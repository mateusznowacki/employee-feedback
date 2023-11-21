package pl.edu.pwr.service;

import pl.edu.pwr.model.Feedback;

import java.util.ArrayList;

public interface FeedbackService {
    void addFeedback(Feedback feedback);

    void deleteFeedback(int id, boolean deleteAll);

    public ArrayList<Feedback> getFeedbackByTime(String timePeriod, int employeeId);

    void editFeedback(Feedback feedback);

}
