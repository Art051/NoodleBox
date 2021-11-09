package com.company;

import java.util.Scanner;

public class Console {

    Scanner scanner = new Scanner(System.in);
    NoodleBox noodleBox = new NoodleBox();


    //offer Menu selection
    public void offerMenus() {
        String menuSelected;
        System.out.println("""
                Please type 'Menu' to see the entire menu.\s
                Or type 'Noodles', 'Toppings' or 'Sauces' to see the respective menu sections.\s
                Otherwise, if you're ready to order, type 'order'.""");
        menuSelected = scanner.nextLine().toLowerCase().trim();
        while (!menuSelected.equals("order")) {
            while ((!menuSelected.equals("menu") &&
                    !menuSelected.equals("noodles") &&
                    !menuSelected.equals("order") &&
                    !menuSelected.equals("toppings") &&
                    !menuSelected.equals("sauces"))) {
                System.out.println("Please enter a valid selection!");
                menuSelected = scanner.nextLine().toLowerCase().trim();
            }
            if (menuSelected.equals("order"))
                break;
            else switch (menuSelected) {
                case ("menu") -> printMenu();
                case ("noodles") -> printSectionOptions(noodleBox.noodleOptions);
                case ("toppings") -> printSectionOptions(noodleBox.toppingOptions);
                case ("sauces") -> printSectionOptions(noodleBox.sauceOptions);
            }
            System.out.println("_____________________");
            System.out.println("If you'd like to see another section, please enter the appropriate word. \n" +
                    "Otherwise, if you're ready to order, type 'order.'");
            menuSelected = scanner.nextLine().toLowerCase().trim();
        }
    }

    //print whole menu
    private void printMenu() {
        printSectionOptions(noodleBox.noodleOptions);
        System.out.println();
        printSectionOptions(noodleBox.toppingOptions);
        System.out.println();
        printSectionOptions(noodleBox.sauceOptions);
    }

    //print individual menu section options
    public void printSectionOptions(String[] stringArray) {
        for (String sectionOptions : stringArray)
            System.out.println(sectionOptions);
    }

    //print the final order
    public void printOrder(NoodleBox noodleBox) {
        System.out.println("""
                If you would like to review your order please say one of the following options:\s
                'Whole order' to see every noodle box's contents.\s
                'No' if you wouldn't like to see your order.\s
                '1', '2', or '3' to see the 1st, 2nd, or 3rd box's contents.""");
        noodleBox.customerResponse = noodleBox.scanner.nextLine().toLowerCase().trim();
        int noodleArrayIndex = 0;
        switch (noodleBox.customerResponse) {
            case ("whole order"): {
                while (noodleArrayIndex < noodleBox.noodleBoxArrayList.size()) {
                    System.out.println(noodleBox.noodleBoxArrayList.get(noodleArrayIndex++));
                }
            }
            break;
            case ("1"):
                System.out.println(noodleBox.noodleBoxArrayList.get(0));
                break;
            case ("2"):
                System.out.println(noodleBox.noodleBoxArrayList.get(1));
                break;
            case ("3"):
                System.out.println(noodleBox.noodleBoxArrayList.get(2));
                break;
            case ("no"):
                break;
        }
    }
}