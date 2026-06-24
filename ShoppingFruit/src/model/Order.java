/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Order {
    private Fruit fruits;
    private int quantity;

    public Order(Fruit fruits, int quantity) {
        this.fruits = fruits;
        this.quantity = quantity;
    }

    public Fruit getFruits() {
        return fruits;
    }

    public void setFruits(Fruit fruits) {
        this.fruits = fruits;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public double getAmount(){
        return fruits.getPrice() * quantity;
    }
}
