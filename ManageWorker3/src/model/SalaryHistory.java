package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SalaryHistory {

    private Worker worker;
    private Status status;
    private double oldSalary;
    private double salary;
    private Date date;

    public SalaryHistory(Worker worker, Status status, double salary, Date date) {
        this.worker = worker;
        this.status = status;
        this.oldSalary = worker.getOldSalary();
        this.salary = salary;
        this.date = date;
    }

    public Worker getWorker() {
        return worker;
    }

    public Status getStatus() {
        return status;
    }

    public double getSalary() {
        return salary;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("%-5s %-10s %-5d %-10.2f %-10.2f %-10s %-15s",
                worker.getCode(),
                worker.getName(),
                worker.getAge(),
                oldSalary,
                salary,
                status,
                df.format(date));
    }
}
