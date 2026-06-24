/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class TaskModel {

    private List<Task> task;
    private int lastID = 0;

    public TaskModel() {
        this.task = new ArrayList<>();
    }

    public List<Task> getTask() {
        return task;
    }

    public void setTask(List<Task> task) {
        this.task = task;
    }

    public boolean checkDoublicate(int ID, String requirementName, Date date,
            double planFrom, double planTo, String assign,
            String reviewer) {
        for (Task task1 : task) {
            if (task1.getId() == ID
                    && task1.getRequirementName().equalsIgnoreCase(requirementName)
                    && task1.getDate().compareTo(date) == 0
                    && task1.getPlanFrom() == planFrom
                    && task1.getPlanTo() == planTo
                    && task1.getAssignee().equalsIgnoreCase(assign)
                    && task1.getReviewer().equalsIgnoreCase(reviewer)) {
                return true;
            }
        }
        return false;
    }

    public int add(int ID, String requirementName, Date date,
            double planFrom, double planTo, String assign,
            String reviewer) throws Exception {
        if (checkDoublicate(ID, requirementName, date, planFrom, planTo, assign, reviewer)) {
            throw new Exception("task is existed!!1");
        }
        Task t = new Task(++lastID, ID, requirementName, date, planFrom, planTo, assign, reviewer);
        if (task.add(t)) {
            return t.getId();
        }
        throw new Exception("con not add!!!");
    }

    public int getIndexByID(int id) {
        for (int i = 0; i < task.size(); i++) {
            if (task.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
    public Task delete(int id){
        int index = getIndexByID(id);
        if(index == -1){
            
        }
    }
}
