package com.cristian.iphone;

public class PhoneApp extends App {

    public PhoneApp() {
    }

    private void call(String contact) {
        System.out.println("Calling " + contact + "...");
    }

    private void answer() {
        System.out.println("Answering call.");
    }

    private void voiceMail() {
        System.out.println("You have " + Iphone.random.nextInt(15) + " voice messages in your voice mail.");
    }

    @Override
    public void showOptions() {

        System.out.println("\tPHONE APP");
        System.out.println("1. make a call.");
        System.out.println("2. answer a call.");
        System.out.println("3. check your voice mail.");
        super.showIcons();
        System.out.print(": ");
        optionManager(getInput());
    }

    @Override
    public void optionManager(Integer option) {
        switch (option) {
            case 1 -> {
                System.out.println("Enter a contact to call: ");
                String contact = Iphone.input.next();
                call(contact);
            }
            case 2 -> answer();
            case 3 -> voiceMail();
            case 0 -> Iphone.homeScreen.showOptions();
            case -1 -> Iphone.turnOff();
            default -> {
                System.out.println("Invalid option, try again");
                showOptions();
            }
        }
    }
}
