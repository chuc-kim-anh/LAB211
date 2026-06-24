/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
    private int id;
    private int taskTypeID;
    private String requirementName;
    private Date date;
    private double planFrom;
    private double planTo;
    private String assignee;
    private String reviewer;

    public Task(int id, int taskTypeID, String requirementName, Date date,
                double planFrom, double planTo, String assignee, String reviewer) {
        this.id = id;
        this.taskTypeID = taskTypeID;
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public int getTaskTypeID() {
        return taskTypeID;
    }

    public String getTaskTypeName() {
        switch (taskTypeID) {
            case 1: return "Code";
            case 2: return "Test";
            case 3: return "Design";
            case 4: return "Review";
            default: return "Unknown";
        }
    }

    public String getRequirementName() {
        return requirementName;
    }

    public Date getDate() {
        return date;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public String getAssignee() {
        return assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return String.format("%-5d%-20s%-10s%-15s%-10.1f%-15s%-15s",
                id, requirementName, getTaskTypeName(), sdf.format(date),
                planTo - planFrom, assignee, reviewer);
    }
}
