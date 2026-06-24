package controller;

import model.*;
import view.View;

public class Controller {

    private final WorkerManager manager = new WorkerManager();

    public void run() {
        while (true) {
            View.menu();
            int choice = Validate.getInt(1, 5);

            switch (choice) {
                case 1:
                    addWorker();
                    break;
                case 2:
                    updateSalary(Status.UP);
                    break;
                case 3:
                    updateSalary(Status.DOWN);
                    break;
                case 4:
                    View.display(manager.getSalaryHistory());
                    break;
                case 5:
                    return;
                default:
                    View.showMessage("Invalid choice!");
            }

        }
    }

    private void addWorker() {
        View.showMessage("Enter code:");
        String code = Validate.getString();

        View.showMessage("Enter name:");
        String name = Validate.getString();

        View.showMessage("Enter age:");
        int age = Validate.getInt(18, 65);

        View.showMessage("Enter salary:");
        double salary = Validate.getDouble(0, Double.MAX_VALUE);

        View.showMessage("Enter location:");
        String location = Validate.getString();

        boolean result = manager.addWorker(new Worker(code, name, age, salary, location));

        if (result) {
            View.showMessage("Add success");
        } else {
            View.showMessage("Worker existed");
        }

    }

    private void updateSalary(Status status) {
        View.showMessage("Enter worker code:");
        String code = Validate.getString();

        View.showMessage("Enter amount:");
        double amount = Validate.getDouble(0, Double.MAX_VALUE);

        boolean result = manager.changeSalary(code, amount, status);
        if (result) {
            View.showMessage("Update success");
        } else {
            View.showMessage("Update failed");
        }
    }
}
