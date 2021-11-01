package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Console {

    Scanner scanner = new Scanner(System.in);
    NoodleBox noodleBox = new NoodleBox();

    //offer Menu selection
    public void offerMenus() {
        System.out.println("Please type 'Menu' to see the entire menu. \n" +
                "Or type 'Noodles', 'Toppings' or 'Sauces' to see the respective menu sections");
        String menuSelected = scanner.nextLine().toLowerCase(Locale.ROOT);
        while ((!menuSelected.equals("menu") &&
                !menuSelected.equals("noodles") &&
                !menuSelected.equals("toppings") &&
                !menuSelected.equals("sauces"))) {
            System.out.println("Please enter a valid selection!");
            menuSelected = scanner.nextLine().toLowerCase(Locale.ROOT);
        }
        switch (menuSelected) {
            case ("menu") -> printMenu();
            case ("noodles") -> printSectionOptions(noodleBox.noodleOptions);
            case ("toppings") -> printSectionOptions(noodleBox.toppingOptions);
            case ("sauces") -> printSectionOptions(noodleBox.sauceOptions);
        }
        System.out.println("_____________________");
    }

    //print whole menu
    private void printMenu() {
        printSectionOptions(noodleBox.noodleOptions);
        System.out.println();
        printSectionOptions(noodleBox.toppingOptions);
        System.out.println();
        printSectionOptions(noodleBox.sauceOptions);
    }

    //print noodle options
    public void printSectionOptions(String[] stringArray) {
        for (String sectionOptions : stringArray)
            System.out.println(sectionOptions);
    }
}