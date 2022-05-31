package com.bduman.cracklock;

public class NNumberInTheWrongPlace implements Hint {
    private final Digit[] hintDigits;
    private final int n;

    public NNumberInTheWrongPlace(Digit[] hintDigits, int n) {
        this.hintDigits = hintDigits;
        this.n = n;
    }

    @Override
    public boolean apply(Digit[] digits) {
        int matched = 0;
        for (int i = 0; i < digits.length; i++) {
            Digit digit = digits[i];
            int number = digit.getNumber();
            Digit hintDigit = hintDigits[i];
            int hintNumber = hintDigit.getNumber();
            boolean anyMatch = anyMatch(digit);
            if (anyMatch && hintNumber != number) {
                matched++;
            }
        }

        if (n != matched) {
            return false;
        }

        return true;
    }

    private boolean anyMatch(Digit digit) {
        int number = digit.getNumber();

        for (Digit hintDigit : hintDigits) {
            int hintNumber = hintDigit.getNumber();
            if (hintNumber == number) {
                return true;
            }
        }

        return false;
    }
}
