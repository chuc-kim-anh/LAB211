/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import model.Order;

/**
 *
 * @author ADMIN
 */
public class View {
    public static void menu(){
        
    }
    
    public static void message(String mess){
        System.out.println(mess);
    }
    
    public static void displayFruitList(ArrayList<String[]> list ){
        if(list.isEmpty()){
            System.out.println("No fruit available");
            return;
        }
    }
    public static void displayBill(ArrayList<String[]> list,double total){
        
    }
    public static void displayCustomerOrder(String name,ArrayList<String[]> list, double total){
        
    }
}
