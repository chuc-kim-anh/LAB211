package controller;

import model.*;
import view.View;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class OrderController {

    private OrderService service = new OrderService();

    public void run() {

        while (true) {

            System.out.println();
            View.menu();
            int choice = Validate.checkInt(1, 4);

            switch (choice) {
                case 1:
                    createFruit();
                    break;
                case 2:
                    viewOrders();
                    break;
                case 3:
                    shopping();
                    break;
                case 4:
                    return;
            }
        }
    }

    // ================= CREATE =================
    private void createFruit() {

        while (true) {

            View.message("Enter Fruit ID:");
            int id = Validate.checkInt(1, Integer.MAX_VALUE);

            if (service.isDuplicateId(id)) {
                View.message("Duplicate ID!");
                continue;
            }

            View.message("Enter Fruit Name:");
            String name = Validate.checkString();

            View.message("Enter Price:");
            double price = Validate.checkInt(1, Integer.MAX_VALUE);

            View.message("Enter Quantity:");
            int quantity = Validate.checkInt(1, Integer.MAX_VALUE);

            View.message("Enter Origin:");
            String origin = Validate.checkString();

            service.addFruit(new Fruit(id, name, price, quantity, origin));

            View.message("Create fruit successfully!");
            View.message("Continue (Y/N)?");

            if (!Validate.checkYN()) {
                break;  
            }
        }
    }

    // ================= SHOPPING =================
    private void shopping() {

        if (service.getFruitList().isEmpty()) {
            View.message("No fruit available!");
            return;
        }

        ArrayList<Order> orderList = new ArrayList<>();

        while (true) {

            ArrayList<Fruit> available = getAvailableFruit();
            if (available.isEmpty()) {
                View.message("All fruits are sold out!");
                break;
            }

            ArrayList<String[]> fruitData = convertToFruitData(available);
            View.displayFruitList(fruitData);

            View.message("Select ID:");
            int id = Validate.checkInt(1, Integer.MAX_VALUE);

            Fruit fruit = service.findFruitById(id);

            if (fruit == null || fruit.getQuantity() == 0) {
                View.message("Not available!");
                continue;
            }

            View.message("You selected: " + fruit.getName());

            View.message("Please input quantity:");
            int quantity = Validate.checkInt(1, fruit.getQuantity());

            fruit.setQuantity(fruit.getQuantity() - quantity);

            orderList.add(new Order(fruit, quantity));

            View.message("Do you want to order now (Y/N)?");
            if (Validate.checkYN()) {
                break;
            }
        }

        double total = service.calculateTotal(orderList);

        ArrayList<String[]> billData = convertToBillData(orderList);

        View.displayBill(billData, total);

        View.message("Input your name:");
        String name = Validate.checkString();

        service.saveOrder(name, orderList);

        View.message("Order saved successfully!");
    }

    // ================= VIEW ORDERS =================
    private void viewOrders() {

        Hashtable<String, ArrayList<ArrayList<Order>>> table = service.getOrderTable();

        if (table.isEmpty()) {
            View.message("No orders yet!");
            return;
        }

        for (Map.Entry<String, ArrayList<ArrayList<Order>>> entry : table.entrySet()) {
            String customer = entry.getKey();
            ArrayList<ArrayList<Order>> orders = entry.getValue();
            
            for (ArrayList<Order> order : orders) {

                double total = service.calculateTotal(order);

                ArrayList<String[]> billData = convertToBillData(order);

                View.displayCustomerOrder(customer, billData, total);
            }
        }
    }

    // ================= CONVERT METHODS =================
    private ArrayList<String[]> convertToFruitData(ArrayList<Fruit> list) {

        ArrayList<String[]> result = new ArrayList<>();

        for (Fruit f : list) {
            String[] row = new String[5];
            row[0] = String.valueOf(f.getId());
            row[1] = f.getName();
            row[2] = f.getOrigin();
            row[3] = String.format("%.2f", f.getPrice());
            row[4] = String.valueOf(f.getQuantity());
            result.add(row);
        }

        return result;
    }

    private ArrayList<String[]> convertToBillData(ArrayList<Order> list) {

        ArrayList<String[]> result = new ArrayList<>();

        for (Order o : list) {
            String[] row = new String[4];
            row[0] = o.getFruit().getName();
            row[1] = String.valueOf(o.getQuantity());
            row[2] = o.getFruit().getPrice() + "$";
            row[3] = o.getAmount() + "$";
            result.add(row);
        }

        return result;
    }

    private ArrayList<Fruit> getAvailableFruit() {

        ArrayList<Fruit> result = new ArrayList<>();

        for (Fruit f : service.getFruitList()) {
            if (f.getQuantity() > 0) {
                result.add(f);
            }
        }
        return result;
    }
}
