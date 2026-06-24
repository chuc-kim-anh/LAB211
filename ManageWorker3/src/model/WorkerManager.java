package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class WorkerManager {

    private List<Worker> workers = new ArrayList<>();
    private List<SalaryHistory> histories = new ArrayList<>();

    public boolean addWorker(Worker worker) {
        if (findWorker(worker.getCode()) != null) {
            return false;
        }
        return workers.add(worker);
    }

    public Worker findWorker(String code) {
        for (Worker w : workers) {
            if (w.getCode().equals(code)) {
                return w;
            }
        }
        return null;
    }

    public boolean changeSalary(String code, double amount, Status status) {
        Worker worker = findWorker(code);
        if (worker == null || amount <= 0) {
            return false;
        }

        double newSalary = worker.getSalary();

        if (status == Status.UP) {
            newSalary += amount;
        } else {
            if (newSalary - amount < 0) {
                return false;
            }
            newSalary -= amount;
        }

        worker.setSalary(newSalary);
        histories.add(new SalaryHistory(worker, status, newSalary, new Date()));
        return true;
    }

    public List<SalaryHistory> getSalaryHistory() {
        Collections.sort(histories, new Comparator<SalaryHistory>() {
            @Override
            public int compare(SalaryHistory h1, SalaryHistory h2) {
                return h1.getWorker().getCode()
                        .compareToIgnoreCase(h2.getWorker().getCode());
            }
        });
        return histories;
    }
}
