package com.cristian;

import com.cristian.iphone.Iphone;

public class Main {
    public static void main(String[] args) {
        System.out.println("tip: enter -1 to turn off your Iphone");
        Iphone iphone = new Iphone();
        Iphone.turnOn();
    }
}