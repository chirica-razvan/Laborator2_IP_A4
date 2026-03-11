package org.example;

public class Main {
    public static void main(String[] args) {System.out.printf("Hello and welcome!");
        // 1. Instantiate the object (The Profile)
        Profile userProfile = new Profile("P104", "CodeAndCoffee");

        // 2. Call the important method to create setups
        // Notice how we don't pass a setupId; the class calculates it automatically.
        userProfile.createNewSetup("Triple Monitor Developer Workstation");
        userProfile.createNewSetup("Minimalist WFH Laptop Stand setup");

        // 3. Add ratings to the setups
        userProfile.rateSetup(1, 5.0);
        userProfile.rateSetup(1, 4.5);
        userProfile.rateSetup(2, 4.0);
        userProfile.rateSetup(2, 3.5);
        userProfile.rateSetup(2, 4.2);

        // 4. Call the method to display the results
        userProfile.displayProfileSummary();

        BudgetChecker myHouse = new BudgetChecker(20);


        Product smartTv = new Product("Samsung", "TV", "Bluetooth");
        Product laptop = new Product("Asus", "Laptop", "Wi-fi");
        Product bulb = new Product("Phillips", "light bulb", "cablu");

        myHouse.addProduct(smartTv, 10);
        myHouse.addProduct(laptop, 10);
        myHouse.addProduct(bulb, 10);
    }
}