/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import model.Fruit;
import model.Order;
import model.OrderService;
import view.View;

/**
 *
 * @author ADMIN
 */
public class OrderController {

    private OrderService service = new OrderService();

    public void run() {

    }

    private void createFruit() {
        while (true) {
            View.message("Enter ID: ");
            int id = Validate.checkInt(0, Integer.MAX_VALUE);
            if (service.isDoublicateID(id)) {
                View.message("Fruit is Existed");
                continue;
            }
            View.message("Enter name: ");
            String name = Validate.checkString();

            View.message("Enter price: ");
            int price = Validate.checkInt(1, Integer.MAX_VALUE);

            View.message("Enter quantity: ");
            int quantity = Validate.checkInt(1, Integer.MAX_VALUE);

            View.message("Enter origin: ");
            String origin = Validate.checkString();

            service.addFruit(new Fruit(id, name, price, quantity, origin));

            View.message("Create fruit success!!");
            View.message("Continue? Y/N");
            if (! Validate.checkYN()) {
                break;
            }
        }
    }
    public void shopping(){
        if(service.getFruitList().isEmpty()){
            View.message("No fruit available!!!");
            return;
        }
        ArrayList<Order> orderList =  new ArrayList<>();
        while (true) {            
            ArrayList<Fruit> available = getAvailableFruit();
            
            if(available.isEmpty()){
                View.message("All fruit are sold out!!!");
                return;
            }
            ArrayList<String[]> fruitData = convertFruitData(available);
            View.displayFruitList(fruitData);
            View.message("Enter ID: ");
            int id = Validate.checkInt(0, Integer.MAX_VALUE);
            Fruit fruit = service.findFruit(id);
            if(fruit == null || fruit.getQuantity() == 0){
                View.message("not available");
                continue;
            }
            View.message("you select: " + fruit.getName());
            View.message("Enter quantity: ");
            int quantity = Validate.checkInt(1, fruit.getQuantity());
            
           fruit.setQuantity(fruit.getQuantity() - quantity);
           
           orderList.add(new Order(fruit, quantity));
           View.message("Do you want order now? Y/N");
           if(Validate.checkYN()){
               break;
           }
        }
        double total = service.caculateBill(orderList);
        ArrayList<String[]> billData = convertBillData(orderList);
        View.displayBill(billData, total);
        View.message("Enter your name: ");
        String name = Validate.checkString();
        service.saveOrder(name, orderList);
        View.message("Save order successfully!!!");
    }
    private void viewOrder(){
        Hashtable<String, ArrayList<Order> > table =  service.getOrder();
        if(table.isEmpty()){
            View.message("No order yet");
            return;
        }
           for (Map.Entry<String, ArrayList<Order>> entry : table.entrySet()) {
            String customer = entry.getKey();
            ArrayList<Order> orders = entry.getValue();
            double total = service.caculateBill(orders);
            
            ArrayList<String[]> bill = convertBillData(orders);
            View.displayCustomerOrder(customer, bill, total);
        }
        
    }
    
    
    private ArrayList <String[]> convertFruitData(ArrayList<Fruit> list){
        ArrayList <String[]> result = new ArrayList<>();
        
        for (Fruit f : list) {
            String[] row = new String[4];
            row[0] = String.valueOf(f.getId());
            row[1] = f.getName();
            row[2] = f.getOrigin();
            row[3] = String.valueOf(f.getPrice());
            result.add(row);
        }
        return result;
    }
    
    private ArrayList<String[]> convertBillData(ArrayList<Order> list){
        ArrayList<String[]> result = new ArrayList<>();
        for (Order o : list) {
            String[] row  = new String[4];
            row[0] = o.getFruits().getName();
            row[1] = String.valueOf(o.getQuantity());
            row[2] = o.getFruits().getOrigin();
            row[3] = String.valueOf(o.getAmount());
            result.add(row);
        }
        return result;
    }
    private ArrayList<Fruit> getAvailableFruit(){
        ArrayList<Fruit> result = new ArrayList<>();
        
        for (Fruit fruit : service.getFruitList()) {
            if(fruit.getQuantity() > 0){
                result.add(fruit);
            }
        }
        return result;
    }
}
