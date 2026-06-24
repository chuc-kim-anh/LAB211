package view;

import java.util.List;
import model.Report;
import model.Student;

public class View {

    public static void message(String msg) {
        System.out.println(msg);
    }

    public static void menu() {
        System.out.println("===== STUDENT MANAGEMENT =====");
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
    }

    public static void displayStudent(List<String[]> list) {
        System.out.printf("%-20s %-15s%n",
                "Student Name", "Course");
        for (String[] arr : list) {
            System.out.printf("%-20s %-15s ",
                    arr[0],
                    arr[1]);
        }
    }

//    public static void displayReport(List<Report> list) {
//        System.out.printf("%-20s %-15s %-5s%n",
//                "Student Name", "Course", "Total");
//        for (Report r : list) {
//            System.out.printf("%-20s %-15s %-5d%n",
//                    r.getStudentName(),
//                    r.getCourseName(),
//                    r.getTotalSource());
//        }
//    }
    public static void displayReport(List<String[]> list) {
        System.out.printf("%-20s %-15s %-5s%n",
                "Student Name", "Course", "Total");

        for (String[] arr : list) {
            System.out.printf("%-20s %-15s %-5s%n",
                    arr[0],
                    arr[1],
                    arr[2]);
        }
    }
}
