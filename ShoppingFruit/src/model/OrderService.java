/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

/**
 *
 * @author ADMIN
 */
public class OrderService {
    private ArrayList<Fruit> fruitList = new ArrayList<>();
    private Hashtable<String,ArrayList<Order>> order = new Hashtable<>();

    public ArrayList<Fruit> getFruitList() {
        return fruitList;
    }

    public Hashtable<String, ArrayList<Order>> getOrder() {
        return order;
    }

    public boolean isDoublicateID(int id){
        for (Fruit fruit : fruitList) {
            if(fruit.getId() == id){
                return true;
            }
        }
        return false;
    }
    public void addFruit(Fruit fruits){
       fruitList.add(fruits);
    }
    public Fruit findFruit(int id){
        for (Fruit fruit : fruitList) {
            if(fruit.getId() == id)
                return fruit;
        }
        return null;
    }
    public double caculateBill(ArrayList<Order> list){
        double total = 0;
        for (Order o1 : list) {
            total += o1.getAmount();
        }
        return total;
    }
    public void saveOrder(String name, ArrayList<Order> list){
        order.put(name, list);
    }
}
