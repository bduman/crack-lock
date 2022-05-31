package com.bduman.cracklock;

public class NothingIsCorrect implements Hint {
    private final Digit[] hintDigits;

    public NothingIsCorrect(Digit[] hintDigits) {
        this.hintDigits = hintDigits;
    }

    @Override
    public boolean apply(Digit[] digits) {
        for (Digit digit : digits) {
            boolean anyMatch = anyMatch(digit);
            if (anyMatch) {
                return false;
            }
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
