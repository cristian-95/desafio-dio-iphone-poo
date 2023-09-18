package com.cristian.iphone;

import java.util.Random;
import java.util.Scanner;

public class Iphone {

    public static final Scanner input = new Scanner(System.in);
    public static final Random random = new Random(System.currentTimeMillis());
    public PhoneApp phoneApp;
    public Ipod ipod;
    public Safari safari;

    public Iphone() {
        this.phoneApp = new PhoneApp();
        this.ipod = new Ipod();
        this.safari = new Safari();
    }


}
