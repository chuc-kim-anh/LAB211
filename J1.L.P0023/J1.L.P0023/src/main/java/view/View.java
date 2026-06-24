package view;

import java.util.ArrayList;

public class View {

    public static void menu() {
        System.out.println("\nFRUIT SHOP SYSTEM");
        System.out.println("1. Create Fruit");
        System.out.println("2. View Orders");
        System.out.println("3. Shopping");
        System.out.println("4. Exit");
        System.out.print("Choose: ");
    }

    public static void message(String msg) {
        System.out.println(msg);
    }

    public static void displayFruitList(ArrayList<String[]> list) {
        if (list.isEmpty()) {
            message("No fruits available!");
            return;
        }
        System.out.printf("%-5s %-15s %-15s %-10s %-10s\n",
                "ID", "Name", "Origin", "Price","Quantity");

        for (String[] row : list) {
            System.out.printf("%-5s %-15s %-15s %-10s %-10s\n",
                    row[0], row[1], row[2], row[3] ,row[4]);
        }
    }

public static void displayBill(ArrayList<String[]> list,double total) {

    System.out.printf("%-15s %-10s %-10s %-10s\n",
            "Product", "Quantity", "Price", "Amount");

    for (String[] row : list) {
        System.out.printf("%-15s %-10s %-10s %-10s\n",
                row[0], row[1], row[2], row[3]);
    }

    message("Total: " + total + "$");
}

    public static void displayCustomerOrder( String name, ArrayList<String[]> list,  double total) {
        message("\nCustomer: " + name);
        displayBill(list, total);
    }
}