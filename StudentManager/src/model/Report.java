/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Report {

    private Student student;
    private String courseName;
    private int totalSource;

    public Report() {
    }

    public Report(Student student, String courseName, int totalSource) {
        this.student = student;
        this.courseName = courseName;
        this.totalSource = totalSource;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }



    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getTotalSource() {
        return totalSource;
    }

    public void setTotalSource(int totalSource) {
        this.totalSource = totalSource;
    }

}
