package model;

public class Order {

    private Fruit fruit;
    private int quantity;

    public Order(Fruit fruit, int quantity) {
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getAmount() {
        return fruit.getPrice() * quantity;
    }
}