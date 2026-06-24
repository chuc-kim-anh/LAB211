/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validation {
    private static final Scanner sc = new Scanner(System.in);

public static int checkInt( int min, int max) {
        
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                if (result >= min && result <= max) {
                    return result;
                } else {
                    System.out.print("please enter [" + min + "->" + max + "]: ");
                }
            } catch (Exception e) {
                System.out.print("please enter Integer Number: ");
            }

        }
    }
       public static double checkDouble( double min, double max) {
        
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine());
                if (result >= min && result <= max) {
                    return result;
                } else {
                    System.out.print("please enter [" + min + "->" + max + "]: ");
                }
            } catch (Exception e) {
                System.out.print("please enter Integer Number: ");
            }

        }
    }
    public static String checkString() {
     
        while (true) {
            String result = sc.nextLine().trim();
            if (!result.isEmpty()) {
                return result;
            } else {
                System.out.print("please enter String: ");
            }
        }
    }

    public static Date checkDate(String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
        while (true) {
            try {
                System.out.print(msg);
                return sdf.parse(sc.nextLine().trim());
            } catch (ParseException e) {
                System.out.println("Invalid date! Format: dd-MM-yyyy");
            }
        }
    }
}

