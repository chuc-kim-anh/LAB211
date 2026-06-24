package controller;

import java.util.Scanner;

public class Validate {

    private static final Scanner SC = new Scanner(System.in);

    public static int getInt(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(SC.nextLine());
                if (n >= min && n <= max) {
                    return n;
                }
            } catch (Exception ignored) {}
            System.out.print("Enter number [" + min + "-" + max + "]: ");
        }
    }

    public static double getDouble(double min,double max) {
        while (true) {
            try {
                double n = Double.parseDouble(SC.nextLine());
                if (n >= min) {
                    return n;
                }
            } catch (Exception ignored) {}
            System.out.print("Enter number >= " + min + "-" + max + ": ");
        }
    }

    public static String getString() {
        while (true) {
            String s = SC.nextLine().trim();
            if (!s.isEmpty()) {
                return s;
            }
            System.out.print("Enter non-empty string: ");
        }
    }
}
