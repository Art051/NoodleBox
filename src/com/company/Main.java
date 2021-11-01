package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //    ArrayList to store the toppings selected
        ArrayList<String> toppingsChosen = new ArrayList<>();

        Console console = new Console();
        NoodleBox noodleBox = new NoodleBox();

        console.offerMenus();

        System.out.println("Please select your noodles:");
        console.printSectionOptions(noodleBox.noodleOptions);
        noodleBox.setNoodleChoice();
        System.out.println("Please select your topping:");
        console.printSectionOptions(noodleBox.toppingOptions);
        noodleBox.setToppingChoice();
        System.out.println("Please select your sauce:");
        console.printSectionOptions(noodleBox.sauceOptions);
        noodleBox.setSauceChoice();

        System.out.println(noodleBox);


    }
}