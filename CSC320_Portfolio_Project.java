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
    // lists out the vehiccles currently in inventory
    public static void list_vehicles(ArrayList<Automobile> inventory) {        
        // make sure there is something in the inventory to print
        if (inventory.isEmpty()) {
            System.out.println("\nThere are no vehicles currently in inventory.");
            return;
        }

        // loop through each vehicle in inventory and print out it's attributes
        System.out.println("\n- Vehicles In Inventory -");
        for(int i = 0; i < inventory.size(); i++) {
            System.out.println("\nVehicle " + (i + 1));
            System.out.println("Make:    " + inventory.get(i).get_make());
            System.out.println("Model:   " + inventory.get(i).get_model());
            System.out.println("Color:   " + inventory.get(i).get_color());
            System.out.println("Year:    " + inventory.get(i).get_year());
            System.out.println("Mileage: " + inventory.get(i).get_mileage());
        }
    }

    // prompts the user to select a vehicle from the current inventory and returns that vehicle
    public static Automobile select_vehicle(Scanner input_scanner, ArrayList<Automobile> inventory) {
        // create uesr input storage variable
        int user_selection = 0;

        // list out the vehicles in inventory
        list_vehicles(inventory);

        // have user input their selection and return it
        System.out.print("\nSelect Vehicle: ");
        user_selection = input_scanner.nextInt();
        return inventory.get((user_selection - 1));
    }

    // asks user to input attributes then builds a new car and adds to inventory with those inputs
    public static void add_vehicle(Scanner input_scanner, ArrayList<Automobile> inventory) {
        // create require variables to store user input
        String make;
        String model;
        String color;
        int year;
        int mileage;

        // get user to input their values
        System.out.println("\n- Add a Vehicle -");
        System.out.print("Make: ");
        make = input_scanner.next();
        System.out.print("Model: ");
        model = input_scanner.next();
        System.out.print("Color: ");
        color = input_scanner.next();
        System.out.print("Year: ");
        year = input_scanner.nextInt();
        System.out.print("Mileage: ");
        mileage = input_scanner.nextInt();

        // create vehicle, add to inventory, then inform user the process is complete
        Automobile auto = new Automobile(make, model, color, year, mileage);
        inventory.add(auto);
        System.out.println("\nVehicle successfully added.");
        
    }

    // removes a selected vehicle from inventory
    public static void remove_vehicle(Scanner input_scanner, ArrayList<Automobile> inventory) {
        // make sure the inventory is not empty
        if (inventory.isEmpty()) {
            System.out.println("\nThere are no vehicles currently in inventory.");
            return;
        }

        // print out that we are in remove method for user
        System.out.println("\n= Removing a Vehicle =");

        // have user select the vehicle they want to remove
        Automobile auto = select_vehicle(input_scanner, inventory);

        // print out which vehicle was selected and that is being removed, then remove it
        System.out.println("Removing " + auto.get_year() + " " + auto.get_model() + " from inventory...");
        inventory.remove(auto);
    }

    public static void update_vehicle(Scanner input_scanner, ArrayList<Automobile> inventory) {
        // make sure the inventory is not empty
        if (inventory.isEmpty()) {
            System.out.println("\nThere are no vehicles currently in inventory.");
            return;
        }

        // print out that we are in update method for user
        System.out.println("\n= Update a Vehicle =");

        // have user select the vehicle they want to update
        Automobile auto = select_vehicle(input_scanner, inventory);

        // have user select the attribute they want to update
        System.out.println("\nSelect an attribute to edit:");
        System.out.println("\n1. Make");
        System.out.println("2. Model");
        System.out.println("3. Color");
        System.out.println("4. Year");
        System.out.println("5. Mileage");
        System.out.print("\nSelection: ");
        int user_selection = input_scanner.nextInt();

        // have user input the new value to change too
        System.out.print("New Value: ");

        // switch statement create the approriate data type and call that correct set function to match
        switch (user_selection) {
            case 1: String new_make = input_scanner.next();
                    auto.set_make(new_make);
                    break;
            case 2: String new_model = input_scanner.next();
                    auto.set_model(new_model);
                    break;
            case 3: String new_color = input_scanner.next();
                    auto.set_color(new_color);
                    break;
            case 4: int new_year = input_scanner.nextInt();
                    auto.set_year(new_year);
                    break;
            case 5: int new_mileage = input_scanner.nextInt();
                    auto.set_mileage(new_mileage);
                    break;
            default: System.out.println("Invalid input");
                break;
        }
        System.out.println("Successfully updated value.");
    }

    // primary loop from which the user will be able to call all the other required methods
    public static void inventory_loop(ArrayList<Automobile> inventory) {
        // create scanner object to get user input and loop boolean to konw when to end the loop
        Scanner input_scanner = new Scanner(System.in);
        boolean loop = true;

        // start the loop
        while(loop) {
            // reset user input variable back to 0 for each loop
            int user_selection = 0;

            // print out options for the user to select from
            System.out.println("\n-------------------------------");
            System.out.println("- Dealership Inventory System -");
            System.out.println("-------------------------------");
            System.out.println("\n 1. View Inventory");
            System.out.println(" 2. Add a Vehicle");
            System.out.println(" 3. Remove a Vehicle");
            System.out.println(" 4. Edit a Vehicle");
            System.out.println(" 5. Exit\n");

            // have user input their selection
            System.out.print("Selection: ");
            user_selection = input_scanner.nextInt();

            // switch through all possible inputs and call the method they requested, default is for invalid inputs
            switch (user_selection) {
                case 1: list_vehicles(inventory);
                        break;
                case 2: add_vehicle(input_scanner, inventory);
                        break;
                case 3: remove_vehicle(input_scanner, inventory);
                        break;
                case 4: update_vehicle(input_scanner, inventory);
                        break;
                case 5: System.out.println("\nExiting application...");
                        loop = false;
                        break;
                default: System.out.println("\nInvalid input - please input a number from the options menu.");
                         break;
            }
        }
        // user has selected to exit, close out the scanner object
        input_scanner.close();
    }
    
    public static void main(String[] args) {
        // create inventory arraylist and start the inventory loop
        ArrayList<Automobile> inventory_array = new ArrayList<Automobile>();
        inventory_loop(inventory_array);
    }
}