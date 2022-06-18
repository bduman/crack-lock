package com.bduman.cracklock;

import java.util.Map;

public class NothingIsCorrect implements Hint {
    private final Digit[] hintDigits;
    private final CorrectnessEngine correctnessEngine;

    public NothingIsCorrect(Digit[] hintDigits, CorrectnessEngine correctnessEngine) {
        this.hintDigits = hintDigits;
        this.correctnessEngine = correctnessEngine;
    }

    @Override
    public boolean apply(Digit[] digits) {
        Map<CorrectnessLevel, Integer> correctnessMap = correctnessEngine.process(hintDigits, digits);
        Integer actualN = correctnessMap.get(CorrectnessLevel.Wrong);
        boolean result = actualN == digits.length;
        return result;
    }
}
