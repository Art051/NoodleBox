package com.company;

public class Main {

    public static void main(String[] args) {

        Console console = new Console();
        NoodleBox noodleBox = new NoodleBox();

        console.offerMenus();
        noodleBox.generateNoodleBox(console);
        console.printOrder(noodleBox);

    }
}