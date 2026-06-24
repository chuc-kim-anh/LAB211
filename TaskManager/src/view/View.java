/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;


import java.text.DecimalFormat;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import model.Task;

public class View {
    private static final Scanner sc = new Scanner(System.in);

    public static void showMenu() {
        System.out.println("========= Task Program =========");
        System.out.println("1. Add Task");
        System.out.println("2. Delete Task");
        System.out.println("3. Display Task");
        System.out.println("4. Exit");
    }

    public static void showMessage(String msg) {
        System.out.println(msg);
    }

     public void displayTask(List<Task> list) {
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

