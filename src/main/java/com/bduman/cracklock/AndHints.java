package com.bduman.cracklock;

public class AndHints implements Hint {
    private final Hint[] hints;

    public AndHints(Hint... hints) {
        this.hints = hints;
    }

    @Override
    public boolean apply(Digit[] digits) {
        boolean result = true;
        for (Hint hint : hints) {
            boolean subResult = hint.apply(digits);
            result = result && subResult;
        }

        return result;
    }
}
