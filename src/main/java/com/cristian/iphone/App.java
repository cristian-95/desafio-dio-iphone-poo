package com.cristian.iphone;

public class App implements Screen {
    @Override
    public void showIcons() {
        System.out.println("\t0. " + IphoneInfo.HOME_BUTTON);
    }

    @Override
    public void showOptions() {
        showIcons();
    }

    public void optionManager(Integer option) {
    }

    public int getInput() {
        int option;
        String entry = Iphone.input.next();
        try {
            option = Integer.parseInt(entry);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            option = 0;
        }
        return option;
    }
}
