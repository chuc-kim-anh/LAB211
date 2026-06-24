/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.*;
import model.Task;
import view.View;

import java.text.SimpleDateFormat;

public class TaskManager {

    private List<Task> list = new ArrayList<>();

    public void run() {
        while (true) {
            View.showMenu();
            View.showMessage("Enter choice: ");
            int choice = Validation.checkInt(1, 4);
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    deleteTask();
                    break;
                case 3:
                    displayTask();
                    break;
                case 4:
                    View.showMessage("Bye!");
                    return;
            }
        }
    }

    public void addTask() {
        try {
            View.showMessage("Requirement Name: ");
            String requirementName = Validation.checkString();

            View.showMessage("1. Code\n"
                    + "2. Test\n"
                    + "3. Design\n"
                    + "4. Review\n");
            View.showMessage("Task   (1-4): ");
            int taskTypeID = Validation.checkInt(1, 4);
            Date date = Validation.checkDate("Date (dd-MM-yyyy): ");
            View.showMessage("From (8.0-17.5): ");
            double planFrom = Validation.checkDouble(8.0, 17.5);
            View.showMessage("To (8.0-17.5): ");
            double planTo = Validation.checkDouble(8.0, 17.5);

            while (planFrom >= planTo) {
                View.showMessage("From must be less than To!");
                View.showMessage("From (8.0-17.5): ");
                planFrom = Validation.checkDouble(8.0, 17.5);
                View.showMessage("To (8.0-17.5): ");
                planTo = Validation.checkDouble(8.0, 17.5);
            }
            View.showMessage("Assignee: ");
            String assignee = Validation.checkString();
            View.showMessage("Reviewer: ");
            String reviewer = Validation.checkString();

            int id = list.isEmpty() ? 1 : list.get(list.size() - 1).getId() + 1;
            Task t = new Task(id, taskTypeID, requirementName, date, planFrom, planTo, assignee, reviewer);
            list.add(t);
            View.showMessage("Add successfully!");
        } catch (Exception e) {
            View.showMessage("Error: " + e.getMessage());
        }
    }

    public void deleteTask() {
        if (list.isEmpty()) {
            View.showMessage("No task to delete!");
            return;
        }
        View.showMessage("Enter ID to delete: ");
        int id = Validation.checkInt(1, Integer.MAX_VALUE);
        Task task = null;
        for (Task t : list) {
            if (t.getId() == id) {
                task = t;
                break;
            }
        }
        if (task != null) {
            list.remove(task);
            View.showMessage("Deleted successfully!");
        } else {
            View.showMessage("Task ID not found!");
        }
    }

    public void displayTask() {
        if (list.isEmpty()) {
            View.showMessage("No task to display!");
            return;
        }
        Collections.sort(list, Comparator.comparingInt(Task::getId));
        System.out.printf("%-5s%-20s%-10s%-15s%-10s%-15s%-15s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        for (Task t : list) {
            System.out.println(t.toString());
        }
    }
}
