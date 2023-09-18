package com.cristian.iphone;

public class HomeScreen extends App {

    public HomeScreen() {
    }

    @Override
    public void showOptions() {
        System.out.println("\n\t HOME SCREEN");
        System.out.println("1. Phone App");
        System.out.println("2. Ipod");
        System.out.println("3. Safari");
        showIcons();
        System.out.print(": ");
        optionManager(getInput());
    }

    @Override
    public void optionManager(Integer option) {
        switch (option) {
            case 1 -> Iphone.phoneApp.showOptions();
            case 2 -> Iphone.ipod.showOptions();
            case 3 -> Iphone.safari.showOptions();
            case 0 -> showOptions();
            case -1 -> Iphone.turnOff();
            default -> {
                System.out.println("invalid option, try again");
                showOptions();
            }
        }
    }
}
