package controller;

import java.util.ArrayList;
import java.util.List;
import model.Report;
import model.Student;
import model.StudentManager;
import view.View;

public class StudentController {

    private StudentManager sm = new StudentManager();

    public void run() {
        while (true) {
            View.menu();
            View.message("Enter choice: ");
            int choice = Validate.checkInt(1, 5);

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    findAndSort();
                    break;
                case 3:
                    updateOrDelete();
                    break;
                case 4:
                    displayReport();
                    break;
                case 5:
                    return;
            }
        }
    }

    // ===== CREATE =====
    private void addStudent() {
        while (true) {
            String id;
            while (true) {
                View.message("Enter ID: ");
                id = Validate.checkString();
                if (sm.checkDuplicateId(id)) {
                    View.message("Duplicate ID!");
                } else {
                    break;
                }
            }

            View.message("Student name: ");
            String name = Validate.checkString();

            View.message("Semester: ");
            String semester = Validate.checkString();

            View.message("Course name (Java / .Net / C/C++): ");
            String course = Validate.checkCourse();

            if (sm.checkDuplicateStudent(name, semester, course)) {
                View.message("double student");
                continue;
            }

            sm.addStudent(new Student(id, name, semester, course));
            View.message("ADD SUCCESS!");

            if (sm.getStudents().size() >= 2) {
                View.message("Do you want to continue (Y/N)? ");
                if (!Validate.checkYN()) {
                    break;
                }
            }
        }
    }

    // ===== FIND & SORT =====
    private void findAndSort() {
        View.message("Enter student name: ");
        String name = Validate.checkString();

        List<Student> list = sm.searchStudent(name);
        if (list.isEmpty()) {
            View.message("Not found!");
        } else {
            sm.sortByName(list);

            List<String[]> data = convertToStudentData(list);

            View.displayStudent(data);
        }
    }

    // ===== UPDATE / DELETE =====
    private void updateOrDelete() {
        View.message("Enter ID: ");
        String id = Validate.checkString();

        Student s = sm.searchById(id);

        if (s == null) {
            View.message("Student not found!");
            return;
        }

        View.message("Do you want to Update (U) or Delete (D)? ");
        boolean isUpdate = Validate.checkUD();

        if (isUpdate) {
            View.message("New name: ");
            String name = Validate.checkString();

            View.message("New semester: ");
            String semester = Validate.checkString();

            View.message("New course (Java / .Net / C/C++): ");
            String course = Validate.checkCourse();

            s.setStudentName(name);
            s.setSemester(semester);
            s.setCourseName(course);

            View.message("UPDATE SUCCESS!");
        } else {
            View.message("Confirm delete (Y/N)? ");
            if (Validate.checkYN()) {
                sm.deleteStudent(s);
                View.message("DELETE SUCCESS!");
            }
        }
    }

    // ===== REPORT =====
//    private void displayReport() {
//        List<Report> list = sm.count();
//        View.displayReport(list);
//    }
    private void displayReport() {
        List<String[]> list = sm.count();
        View.displayReport(list);
    }

    public List<String[]> convertToStudentData(List<Student> list) {
        List<String[]> result = new ArrayList<>();

        for (Student s : list) {
            String[] arr = new String[2];
            arr[0] = s.getStudentName();  // cột 0
            arr[1] = s.getCourseName();   // cột 1
            result.add(arr);
        }

        return result;
    }
}
