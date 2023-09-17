package com.cristian.iphone;

public class App implements Screen{
    @Override
    public void showIcons() {
        System.out.println("\t0. "+IphoneInfo.HOME_BUTTON);
    }

    @Override
    public void showOptions() {
        showIcons();
    }

    public void optionManager(int option){
    }
}
