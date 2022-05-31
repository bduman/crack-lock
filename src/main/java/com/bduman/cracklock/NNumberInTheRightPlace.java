package com.bduman.cracklock;

public class NNumberInTheRightPlace implements Hint {
    private final Digit[] hintDigits;
    private final int n;

    public NNumberInTheRightPlace(Digit[] hintDigits, int n) {
        this.hintDigits = hintDigits;
        this.n = n;
    }

    @Override
    public boolean apply(Digit[] digits) {
        int matched = 0;
        for (int i = 0; i < digits.length; i++) {
            Digit digit = digits[i];
            Digit hintDigit = hintDigits[i];

            int number = digit.getNumber();
            int hintNumber = hintDigit.getNumber();
            if (hintNumber == number) {
                matched++;
            }
        }

        if (n != matched) {
            return false;
        }

        return true;
    }
}
