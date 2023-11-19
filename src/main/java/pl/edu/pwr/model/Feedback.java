package pl.edu.pwr.model;

import java.sql.Date;

public class Feedback {
    private final int opinionID;
    private final int employeeID;
    private final Date date;
    private boolean isPositive;
    private int weight;
    private String comment;

    public Feedback(int opinionID, int employeeID, Date date, boolean isPositive, int weight, String comment) {
        this.opinionID = opinionID;
        this.employeeID = employeeID;
        this.date = date;
        this.isPositive = isPositive;
        this.weight = weight;
        this.comment = comment;
    }

    public int getOpinionID() {
        return opinionID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public Date getDate() {
        return date;
    }

    public boolean isPositive() {
        return isPositive;
    }

    public void setPositive(boolean positive) {
        isPositive = positive;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
