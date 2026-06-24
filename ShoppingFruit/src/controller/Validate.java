/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Validate {
    public static Scanner sc = new Scanner(System.in);
    
    public static int checkInt(int min,int max){
        while(true){
            try{
            int result = Integer.parseInt(sc.nextLine());
            if(result>= min && result<= max){
                return result;
            }else{
                System.out.println("please enter : "+min+" -> "+max);
            }
        }catch(Exception e){
                System.out.println("Invalide!!");
        }
      }
    }
    public static String checkString(){
        while(true){
            
                String result = sc.nextLine().trim();
                if(!result.isEmpty()){
                    return result;
                }else{
                    System.out.println("please enter String: ");
                }
        }
    }
    
    public static boolean checkYN(){
              while (true) {
            String result = sc.nextLine().trim();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.print("please eneter Y/N: ");
        }

    }
    public static boolean checkUD(){
        while(true){
            String result = sc.nextLine().trim();
            if(result.equalsIgnoreCase("U")){
                return true;
            }
            if(result.equalsIgnoreCase("D")){
                return false;
            }
            System.out.print("please enter U/D: ");
        }
    }
      public static String checkCourse() {
        while (true) {
            String course = checkString();
            if (course.equalsIgnoreCase("Java")
                    || course.equalsIgnoreCase(".Net")
                    || course.equalsIgnoreCase("C/C++")) {
                return course;
            }
            System.out.println("Only Java, .Net or C/C++");
        }
    }
}
