package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentManager {

    private List<Student> students = new ArrayList<>();
    private List<Report> reports = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public boolean checkDuplicateId(String id) {
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }
        public boolean checkDuplicateStudent(String name,String semester, String course) {
        for (Student s : students) {
            if (s.getStudentName().equalsIgnoreCase(name)&& s.getSemester().equalsIgnoreCase(semester)&& s.getCourseName().equalsIgnoreCase(course)) {
                return true;
            }
        }
        return false;
    }

    public Student searchById(String id) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    public List<Student> searchStudent(String key) {
        List<Student> list = new ArrayList<>();
        for (Student s : students) {
            if (s.getStudentName().toLowerCase().contains(key.toLowerCase())) {
                list.add(s);
            }
        }
        return list;
    }

    
        public void sortByName(List<Student> list) {
            Collections.sort(list, new Comparator<Student>() {
                @Override
                public int compare(Student s1, Student s2) {
                    return s1.getStudentName().compareToIgnoreCase(s2.getStudentName());
                }
            });
        }

    public void deleteStudent(Student s) {
        students.remove(s);
    }

//    public List<Report> count() {
//        reports.clear();
//
//        for (Student s1 : students) {
//            int total = 0;
//
//            for (Student s2 : students) {
//                if (s1.getStudentName().equalsIgnoreCase(s2.getStudentName())
//                        && s1.getCourseName().equalsIgnoreCase(s2.getCourseName())) {
//                    total++;
//                }
//            }
//
//            boolean exist = false;
//            for (Report r : reports) {
//                if (r.getStudentName().equalsIgnoreCase(s1.getStudentName())
//                        && r.getCourseName().equalsIgnoreCase(s1.getCourseName())) {
//                    exist = true;
//                    break;
//                }
//            }
//
//            if (!exist) {
//                reports.add(new Report(s1.getStudentName(),s1.getCourseName(), total));
//            }
//        }
//        return reports;
//    }
    public List<String[]> count() {
    List<String[]> result = new ArrayList<>();

    for (Student s1 : students) {
        int total = 0;

        for (Student s2 : students) {
            if (s1.getStudentName().equalsIgnoreCase(s2.getStudentName())
                    && s1.getCourseName().equalsIgnoreCase(s2.getCourseName())) {
                total++;
            }
        }

        boolean exist = false;
        for (String[] arr : result) {
            if (arr[0].equalsIgnoreCase(s1.getStudentName())
                    && arr[1].equalsIgnoreCase(s1.getCourseName())) {
                exist = true;
                break;
            }
        }

        if (!exist) {
            result.add(new String[]{
                s1.getStudentName(),
                s1.getCourseName(),
                String.valueOf(total)
            });
        }
    }

    return result;
}
}
