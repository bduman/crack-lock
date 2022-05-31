package com.bduman.cracklock;

public class NNumberIsCorrect implements Hint {
    private final Digit[] hintDigits;
    private final int n;

    public NNumberIsCorrect(Digit[] hintDigits, int n) {
        this.hintDigits = hintDigits;
        this.n = n;
    }

    @Override
    public boolean apply(Digit[] digits) {
        int matched = 0;
        for (Digit digit : digits) {
            boolean anyMatch = anyMatch(digit);
            if (anyMatch) {
                matched++;
            }
        }

        if (matched != n) {
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
