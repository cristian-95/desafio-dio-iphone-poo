package com.cristian.iphone;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Iphone {

    public static Boolean power;
    public static final Scanner input = new Scanner(System.in);
    public static final Random random = new Random(System.currentTimeMillis());
    public static PhoneApp phoneApp;
    public static Ipod ipod;
    public static Safari safari;
    public static HomeScreen homeScreen;

    public Iphone() {
        phoneApp = new PhoneApp();
        ipod = new Ipod();
        safari = new Safari();
        homeScreen = new HomeScreen();
    }

    private static void kernel() {
        while (power) {
            homeScreen.showOptions();
        }
    }

    public static void turnOn() {
        System.out.println("\n\n\n\tIPHONE\n\n\n");
        try {
            TimeUnit.SECONDS.sleep(Iphone.random.nextInt(1));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        power = true;
        kernel();
    }

    public static void turnOff() {
        System.out.println("shutting down...");
        power = false;
    }
}
