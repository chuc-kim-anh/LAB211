package model;

import java.util.ArrayList;
import java.util.Hashtable;

public class OrderService {

    private ArrayList<Fruit> fruitList = new ArrayList<>();
    private Hashtable<String, ArrayList<ArrayList<Order>>> orderTable = new Hashtable<>();

    public ArrayList<Fruit> getFruitList() {
        return fruitList;
    }

    public Hashtable<String, ArrayList<ArrayList<Order>>> getOrderTable() {
        return orderTable;
    }

    public boolean isDuplicateId(int id) {
        for (Fruit f : fruitList) {
            if (f.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void addFruit(Fruit fruit) {
        fruitList.add(fruit);
    }

    public Fruit findFruitById(int id) {
        for (Fruit f : fruitList) {
            if (f.getId() == id) {
                return f;
            }
        }
        return null;
    }

    public double calculateTotal(ArrayList<Order> list) {
        double total = 0;
        for (Order o : list) {
            total += o.getAmount();
        }
        return total;
    }

    public void saveOrder(String name, ArrayList<Order> list) {
        if (!orderTable.containsKey(name)) {
            orderTable.put(name, new ArrayList<>());
        }
        orderTable.get(name).add(list);
    }
}
