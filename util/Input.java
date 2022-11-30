package util;

import java.util.Scanner;

public class Input {
    private Scanner scanner;

    public Input(Scanner scan) {
        this.scanner = scan;
    }

    public String getString() {
        return scanner.nextLine();

    }
    public String getString(String specialMessage) {
        System.out.println(specialMessage + "\n");
        String s = scanner.nextLine();
        return s;
    }
    public boolean yesNo() {
        System.out.println("enter yes/no or y/n");
        String resp = this.scanner.nextLine();
        while (!resp.equalsIgnoreCase("yes") && !resp.equalsIgnoreCase("no") && !resp.equalsIgnoreCase("n") && !resp.equalsIgnoreCase("y")) {
            System.out.println("That is not yes/no or y/n");
            resp = this.scanner.nextLine().trim();
        }
        if (resp.equalsIgnoreCase("y") || resp.equalsIgnoreCase("yes")) {
            System.out.println("you entered = " + resp);
            return true;
        } else if (resp.equalsIgnoreCase("n") || resp.equalsIgnoreCase("no")) {
            System.out.println("you entered = " + resp);
            return false;
        } else return false;
    }


    public int getInt(int min, int max) {
        boolean exitConditionMet = false;
        int number = Integer.MIN_VALUE;
        while (!exitConditionMet) {
            System.out.println("Enter a number between " + min + " and " + max + ":");
            number = this.scanner.nextInt();
            this.scanner.nextLine();
            if (number >= min && number <= max) {
                System.out.println(number + " is in the target range");
                exitConditionMet = true;
            } else {
                System.out.println(number + " is out of target range");
                continue;
            }
        }
        return number;
    }
    public int getInt (){
        int number = scanner.nextInt();
        System.out.println("You entered: "+number);
        return number;
    }

    public double getDouble(double min, double max) {
        boolean exitConditionMet = false;
        double number = Double.MIN_VALUE;
        while (!exitConditionMet) {
            System.out.println("Enter a number between " + min + " and " + max + ":");
            number = this.scanner.nextDouble();
            this.scanner.nextLine();
            if (number >= min && number <= max) {
                System.out.println(number + " is in the target range");
                exitConditionMet = true;
            } else {
                System.out.println(number + " is out of target range");
                continue;
            }
        }
        return number;
    }

    public double getDouble() {
        if (this.scanner.hasNextDouble()) {
            double myDouble = this.scanner.nextDouble();
            this.scanner.nextLine();
            return myDouble;
        } else {
            return Double.MIN_VALUE;
        }
    }


}
