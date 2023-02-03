/*
 * Author: Kyle King
 * Class: CSU Global CSC320-1 - Programming 1
 * Assignment: Portfolio Project - Option 1
 * Date: 1/29/2023
*/

import java.util.ArrayList;
import java.util.Scanner;

class Automobile {
    // class fields
    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;

    // class constructor
    public Automobile(String input_make, String input_model, String input_color, int input_year, int input_mileage) {
        this.make = input_make;
        this.model = input_model;
        this.color = input_color;
        this.year = input_year;
        this.mileage = input_mileage;
    }

    // getter and setter for make
    public String get_make() {
        return make;
    }
    public void set_make(String new_value) {
        this.make = new_value;
    }

    // getter and setter for model
    public String get_model() {
        return model;
    }
    public void set_model(String new_value) {
        this.model = new_value;
    }

    // getter and setter for color
    public String get_color() {
        return color;
    }
    public void set_color(String new_value) {
        this.color = new_value;
    }

    // getter and setter for year
    public int get_year() {
        return year;
    }
    public void set_year(int new_value) {
        this.year = new_value;
    }

    // getter and setter for mileage
    public int get_mileage() {
        return mileage;
    }
    public void set_mileage(int new_value) {
        this.mileage = new_value;
    }
}

public class CSC320_Portfolio_Project {
    public static void list_vehicles(ArrayList<Automobile> inventory) {
        /*
         * loop through the arraylist object and print each car in the list to console
         * will be called when removing, selecting, or updating vehicles
         * 
         * for(int i = 0; i < inventory_array.size(); i++) {
         *    print vehicle i;
         * }
         */
        for(int i = 0; i < inventory.size(); i++) {
            System.out.print("\n" + inventory.get(i).get_make());
            System.out.print("\n" + inventory.get(i).get_model());
            System.out.print("\n" + inventory.get(i).get_color());
            System.out.print("\n" + inventory.get(i).get_year());
            System.out.print("\n" + inventory.get(i).get_mileage());
        }
    }

    public static void select_vehicle() {
        /*
         * call list vehicles to show user current cars in inventory
         * user will select one of those cars, then it will be returned
         * 
         * list_vehicles();
         * selected = scanner.nextint();
         * return selected;
         */
    }

    public static void add_vehicle(Scanner input_scanner, ArrayList<Automobile> inventory) {
        /*
         * prompt user to input required data for a car object, then call car construtor and add to inventory array
         * 
         * string make = scanner.nextln();
         * etc
         * 
         * inventory_array.add(automobile(make,model,color,year,mileage));
         */
        String make;
        String model;
        String color;
        int year;
        int mileage;

        System.out.println("\n- Add a Vehicle -");
        System.out.print("Make: ");
        make = input_scanner.next();
        System.out.print("Model: ");
        model = input_scanner.next();
        System.out.print("Color: ");
        color = input_scanner.next();
        System.out.print("Year: ");
        year = input_scanner.next();
        System.out.print("Mileage: ");
        mileage = input_scanner.next();

        Automobile auto = new Automobile(make, model, color, year, mileage);
        inventory.add(auto);
        
    }

    public static void remove_vehicle() {
        /*
         * call select vehicle to have user select a car in the inventory array
         * remove selected car from the array
         * 
         * selection = select_vehicle();
         * inventory_array.remove(selection);
         */
    }

    public static void update_vehicle() {
        /*
         * call select vehicle to have user select a car in the inventory array
         * have the user select the attribute to update
         * collect updated value from the user
         * call setter method to set the new value
         * 
         * selected_car = select_vehicle();
         * selected_attribute = scanner.nextint();
         * updated_value = scanner.next***();
         * inventory_array[selected_car].selected_attribute.setter(updated_value);
         */
    }

    public static void inventory_loop(ArrayList<Automobile> inventory) {
        /*
         * loop through inventory options and have user select an option until the select exit
         * 
         * while(true) {
         *     print options
         *     have user select option
         *     call that method
         *     if exit, then exit
         * }
         */
        Scanner input_scanner = new Scanner(System.in);
        boolean loop = true;

        while(loop) {
            int user_selection = 0;

            System.out.println("\n-------------------------------");
            System.out.println("- Dealership Inventory System -");
            System.out.println("-------------------------------");
            System.out.println("\n 1. View Inventory");
            System.out.println(" 2. Add a Vehicle");
            System.out.println(" 3. Remove a Vehicle");
            System.out.println(" 4. Edit a Vehicle");
            System.out.println(" 5. Exit\n");

            user_selection = input_scanner.nextInt();

            switch (user_selection) {
                case 1: list_vehicles(inventory);
                        break;
                case 2: add_vehicle(input_scanner, inventory);
                        break;
                case 3: remove_vehicle();
                        break;
                case 4: update_vehicle();
                        break;
                case 5: System.out.println("\nExiting application...");
                        loop = false;
                        break;
                default: System.out.println("\nInvalid input - please input a number from the options menu.");
                         break;
            }
        }

        input_scanner.close();
    }
    
    public static void main(String[] args) {
        /*
         * create inventory array
         * call inventory loop
         */

        ArrayList<Automobile> inventory_array = new ArrayList<Automobile>();
        inventory_loop(inventory_array);

        /*
        String make = "Subaru";
        String model = "WRX";
        String color = "Blue";
        int year = 2017;
        int mileage = 26500;
        Automobile car1 = new Automobile(make,model,color,year,mileage);

        inventory_array.add(car1);
        System.out.print(inventory_array);
        */
    }
}