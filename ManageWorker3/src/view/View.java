package view;

import java.util.List;
import model.SalaryHistory;

public class View {

    public static void menu() {
        System.out.println("======== Worker Management ========");
        System.out.println("1. Add Worker");
        System.out.println("2. Up salary");
        System.out.println("3. Down salary");
        System.out.println("4. Display salary history");
        System.out.println("5. Exit");
    }

    public static void showMessage(String msg) {
        System.out.println(msg);
    }

    public static void display(List<SalaryHistory> list) {
        if (list.isEmpty()) {
            System.out.println("No data");
            return;
        }

        System.out.printf("%-5s %-10s %-5s %-10s %-10s %-10s %-15s\n",
                "Code", "Name", "Age","oldSalary" ,"Salary", "Status", "Date");

        for (SalaryHistory h : list) {
            System.out.println(h);
        }
    }
}
