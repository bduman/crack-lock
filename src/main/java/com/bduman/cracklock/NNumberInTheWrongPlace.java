package com.bduman.cracklock;

import java.util.Map;

public class NNumberInTheWrongPlace implements Hint {
    private final Digit[] hintDigits;
    private final int n;
    private final CorrectnessEngine correctnessEngine;

    public NNumberInTheWrongPlace(Digit[] hintDigits, int n, CorrectnessEngine correctnessEngine) {
        this.hintDigits = hintDigits;
        this.n = n;
        this.correctnessEngine = correctnessEngine;
    }

    @Override
    public boolean apply(Digit[] digits) {
        Map<CorrectnessLevel, Integer> correctnessMap = correctnessEngine.process(hintDigits, digits);
        Integer actualN = correctnessMap.get(CorrectnessLevel.CorrectButWrongPlace);
        boolean result = actualN == n;

        Integer wrongCount = correctnessMap.get(CorrectnessLevel.Wrong);
        int othersCount = digits.length - n;
        if (wrongCount != othersCount) {
            return false;
        }

        return result;
    }
}
