package com.bduman.cracklock;

public class Code {
    private final Digit[] digits;
    private final int number;

    public Code(Digit[] digits) {
        this.digits = digits;
        this.number = calculateNumber(); // TODO: lazy
    }

    public Digit[] getDigits() {
        return digits;
    }

    public int getNumber() {
        return this.number;
    }

    private int calculateNumber() {
        int result = 0;
        int length = digits.length;
        for(int i = 0; i < length; i++) {
            Digit digit = digits[length - i - 1];
            int number = digit.getNumber();
            result += Math.pow(10, i) * number;
        }

        return result;
    }
}
