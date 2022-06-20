package com.bduman.cracklock;

public class Digit {
    private final int place;
    private final int number;

    public Digit(int place, int number) {
        this.place = place;
        this.number = number;
    }

    public int getPlace() {
        return place;
    }

    public int getNumber() {
        return number;
    }
}
