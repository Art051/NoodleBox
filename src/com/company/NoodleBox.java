package com.company;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class NoodleBox {
    Scanner scanner = new Scanner(System.in);

    String noodleChoice = "";
    String sauceChoice = "";
    String toppingChoice = ""; //current individual choice of topping
    ArrayList<String> multipleToppings = new ArrayList<>(); //list to store the choices of toppings
    String multipleToppingsString = ""; // string to convert ArrayList to be printable

    //menu options to choose from
    public final String[] noodleOptions = {"Egg", "Udon", "Rice"};
    public final String[] toppingOptions = {"Chicken", "Beef", "Tofu"};
    public final String[] sauceOptions = {"Black Bean", "Teriyaki", "Hoisin Sauce"};

    public NoodleBox() {
    }

    public void setNoodleChoice() {
        String noodleChoice = scanner.nextLine().toLowerCase(Locale.ROOT);
        while ((!noodleChoice.equals("egg") && !noodleChoice.equals("udon") && !noodleChoice.equals("rice"))) {
            System.out.println("Please enter a valid selection!");
            noodleChoice = scanner.nextLine().toLowerCase(Locale.ROOT);
        }
        switch (noodleChoice) {
            case ("egg") -> noodleChoice = "egg";
            case ("udon") -> noodleChoice = "udon";
            case ("rice") -> noodleChoice = "rice";
        }
        this.noodleChoice = noodleChoice;
    }

    public void setSauceChoice() {
        String sauceChoice = scanner.nextLine().toLowerCase(Locale.ROOT);
        while ((!sauceChoice.equals("black bean") && !sauceChoice.equals("teriyaki") && !sauceChoice.equals("hoisin sauce"))) {
            System.out.println("Please enter a valid selection!");
            sauceChoice = scanner.nextLine().toLowerCase(Locale.ROOT);
        }
        switch (sauceChoice) {
            case ("black bean") -> sauceChoice = "black bean";
            case ("teriyaki") -> sauceChoice = "teriyaki";
            case ("hoisin sauce") -> sauceChoice = "hoisin sauce";
        }
        this.sauceChoice = sauceChoice;
    }

    public void setToppingChoice() {
        String topping = scanner.nextLine().toLowerCase(Locale.ROOT);
        while ((!topping.equals("chicken") && !topping.equals("beef") && !topping.equals("tofu"))) {
            System.out.println("Please enter a valid selection!");
            topping = scanner.nextLine().toLowerCase(Locale.ROOT);
            switch (topping) {
                case ("chicken") -> topping = "chicken";
                case ("beef") -> topping = "beef";
                case ("tofu") -> topping = "tofu";
            }
        }
        this.toppingChoice = topping;
    }

    //set the string which contains the elements of the StringArray so it can be printed
    public void setMultipleToppingsString(String multipleToppingsString) {
        for (String toppings : multipleToppings)
            this.multipleToppingsString = multipleToppingsString + toppings;
    }

    @Override
    public String toString() {
        return "NoodleBox Selections:" + '\n' +
                "Noodle choice: " + noodleChoice + '\n' +
                "Topping choice (single):  " + toppingChoice + '\n' +
                "Topping choices:  " + multipleToppingsString + '\n' +
                "Sauce choice: " + sauceChoice + '\n';
    }
}