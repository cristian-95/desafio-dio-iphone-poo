package com.cristian.iphone;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Safari extends App {

    private final List<String> tabs;
    private String tabOnDisplay;

    public Safari() {
        this.tabs = new ArrayList<>();
        this.tabOnDisplay = "";
    }

    private void displayPage(String site) {
        System.out.println("Displaying site: https://" + site);
        this.tabOnDisplay = site;
        if (!this.tabs.contains(site)) {
            this.tabs.add(site);
        }
    }

    private void reloadTab() {
        System.out.print("reloading tab.");
        try {
            TimeUnit.SECONDS.sleep(Iphone.random.nextInt(3));
            System.out.print(".");
            TimeUnit.SECONDS.sleep(Iphone.random.nextInt(2));
            System.out.print(".");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(" done.");
    }

    private void closeCurrentTab() {
        System.out.println("tab closed.");
        this.tabs.remove(this.tabOnDisplay);
        displayPage(this.tabs.get(0));
    }

    private void addTab(String site) {
        this.tabs.add(site);
        System.out.println("new tab:" + site);
        displayPage(site);
    }

    private void switchTabs() {
        int option;
        System.out.println("\tOpened Tabs");
        for (int i = 1; i <= this.tabs.size(); i++) {
            System.out.println(i + " " + this.tabs.get(i - 1));
        }
        showIcons();
        System.out.print(": ");
        option = Iphone.input.nextInt();

        displayPage(this.tabs.get(option - 1));
    }

    @Override
    public void showOptions() {
        System.out.println("\tSAFARI BROWSER");
        System.out.println("1. access a site.");
        System.out.println("2. reload tab.");
        System.out.println("3. new tab.");
        System.out.println("4. switch tab");
        System.out.println("5. close current tab");
        showIcons();
        System.out.print(": ");
        optionManager(getInput());
    }

    @Override
    public void optionManager(Integer option) {
        switch (option) {
            case 1 -> {
                System.out.println("Enter the site address: ");
                String site = Iphone.input.next();
                displayPage(site);
            }
            case 2 -> reloadTab();
            case 3 -> {
                System.out.println("Enter the site address: ");
                String site = Iphone.input.next();
                addTab(site);
            }
            case 4 -> switchTabs();
            case 5 -> closeCurrentTab();
            case 0 -> Iphone.homeScreen.showOptions();
            case -1 -> Iphone.turnOff();
            default -> {
                System.out.println("Invalid option, try again");
                showOptions();
            }
        }
    }
}
