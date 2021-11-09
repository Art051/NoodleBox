package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class NoodleBox {

    Scanner scanner = new Scanner(System.in);

    String noodleBoxName = "";
    String noodleChoice = "";
    String sauceChoice = "";
    ArrayList<String> toppingsChosen = new ArrayList<>(); //list to store the choices of toppings
    ArrayList<NoodleBox> noodleBoxArrayList = new ArrayList<>(); //ArrayList to store each noodlebox object
    String customerResponse;


    //menu options to choose from
    public final String[] noodleOptions = {"Egg", "Udon", "Rice"};
    public final String[] toppingOptions = {"Chicken", "Beef", "Tofu"};
    public final String[] sauceOptions = {"Black Bean", "Teriyaki", "Hoisin Sauce"};
    int maximumOrderQuantity = 3;

    //create a whole noodle box object
    public void generateNoodleBox(Console console) {
        int i = 1;
        while (noodleBoxArrayList.size() < maximumOrderQuantity) {
            NoodleBox noodleBox = new NoodleBox();
            noodleBox.noodleBoxName = "Noodle Box " + i++;
            System.out.println("Please select your noodles:");
            console.printSectionOptions(noodleBox.noodleOptions);
            noodleBox.setNoodleChoice();
            System.out.println("Please select your topping:");
            console.printSectionOptions(noodleBox.toppingOptions);
            setToppingsChosen(noodleBox.toppingsChosen);
            System.out.println("Please select your sauce:");
            console.printSectionOptions(noodleBox.sauceOptions);
            noodleBox.setSauceChoice();
            System.out.println(noodleBox);
            noodleBoxArrayList.add(noodleBox);
            if (noodleBoxArrayList.size() == 3)
                break;
            if (noodleBoxArrayList.size() < 3)
                System.out.println("Would you like to add another Noodle Box? (Yes/No)");
            customerResponse = scanner.nextLine().toLowerCase().trim();
            while ((!customerResponse.equals("yes") &&
                    !customerResponse.equals("no"))) {
                System.out.println("Please enter either 'Yes' or 'No'!");
                customerResponse = scanner.nextLine().toLowerCase().trim();
            }
            if (customerResponse.equals("no"))
                break;
        }
    }

    //set the noodles selected based on customer input
    public void setNoodleChoice() {
        String noodleChoice = scanner.nextLine().toLowerCase().trim();
        while ((!noodleChoice.equals("egg") && !noodleChoice.equals("udon") && !noodleChoice.equals("rice"))) {
            System.out.println("Please enter a valid selection!");
            noodleChoice = scanner.nextLine().toLowerCase().trim().trim();
        }
        switch (noodleChoice) {
            case ("egg") -> noodleChoice = "egg";
            case ("udon") -> noodleChoice = "udon";
            case ("rice") -> noodleChoice = "rice";
        }
        this.noodleChoice = noodleChoice;
    }

    //set the toppings selected based on customer input
    public void setToppingsChosen(ArrayList<String> toppingsChosen) {
        String topping = "";
        System.out.println("Would you like to add some toppings? (Yes/Next).\n" +
                "Typing 'Next', either now or after adding some topping, will take you to the sauces.");
        topping = scanner.nextLine().toLowerCase().trim();
        if (!(topping.equals("yes") || topping.equals("next"))) {
            System.out.println("Please enter either 'Yes' or 'Next'.");
            topping = scanner.nextLine().toLowerCase().trim();
        }
        while (topping.equals("yes")) {
            for (int i = 0; i < 3; i++) {
                System.out.println("Topping " + (i + 1) + ":");
                topping = scanner.nextLine().toLowerCase().trim();
                if (topping.equals("next"))
                    break;
                else
                    while ((!topping.equals("chicken") && !topping.equals("beef") && !topping.equals("tofu"))) {
                        System.out.println("Please enter a valid selection!");
                        topping = scanner.nextLine().toLowerCase().trim();
                        switch (topping) {
                            case ("chicken") -> topping = "chicken";
                            case ("beef") -> topping = "beef";
                            case ("tofu") -> topping = "tofu";
                        }
                    }
                toppingsChosen.add(topping);
            }
        }
        this.toppingsChosen = toppingsChosen;
    }

    //set the sauce selected based on customer input
    public void setSauceChoice() {
        String sauceChoice = scanner.nextLine().toLowerCase().trim();
        while ((!sauceChoice.equals("black bean") && !sauceChoice.equals("teriyaki") && !sauceChoice.equals("hoisin sauce"))) {
            System.out.println("Please enter a valid selection!");
            sauceChoice = scanner.nextLine().toLowerCase().trim();
        }
        switch (sauceChoice) {
            case ("black bean") -> sauceChoice = "black bean";
            case ("teriyaki") -> sauceChoice = "teriyaki";
            case ("hoisin sauce") -> sauceChoice = "hoisin sauce";
        }
        this.sauceChoice = sauceChoice;
    }

    //capitalises the first letter of each word
    public static String capitalise(String string) {
        String[] words = string.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        if (words[0].length() > 0) {
            stringBuilder.append(Character.toUpperCase(words[0].charAt(0))).append(words[0].subSequence(1, words[0].length()).toString().toLowerCase());
            for (int i = 1; i < words.length; i++) {
                stringBuilder.append(" ");
                stringBuilder.append(Character.toUpperCase(words[i].charAt(0))).append(words[i].subSequence(1, words[i].length()).toString().toLowerCase());
            }
        }
        return stringBuilder.toString();
    }

    //overrides toString to correctly display the noodlebox object(s)
    @Override
    public String toString() {
        return capitalise(noodleBoxName) + ":" + '\n' +
                "Noodle choice: " + capitalise(noodleChoice) + '\n' +
                "Topping choice(s): " + capitalise(toppingsChosen.toString().replace("[", "").replace("]", "")) + '\n' +
                "Sauce choice: " + capitalise(sauceChoice) + '\n';
    }
}