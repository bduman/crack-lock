package com.bduman.cracklock;

import java.util.HashMap;
import java.util.Map;

public class CorrectnessEngine {
    public Map<CorrectnessLevel, Integer> process(Digit[] hintDigits, Digit[] digits) {
        Map<CorrectnessLevel, Integer> result = initResult();

        for (int i = 0; i < digits.length; i++) {
            Digit digit = digits[i];

            CorrectnessLevel correctness = getCorrectness(hintDigits, i, digit);
            result.merge(correctness, 1, Integer::sum);
        }

        return result;
    }

    private Map<CorrectnessLevel, Integer> initResult() {
        Map<CorrectnessLevel, Integer> result = new HashMap<>();
        result.put(CorrectnessLevel.CorrectAndRightPlace, 0);
        result.put(CorrectnessLevel.CorrectButWrongPlace, 0);
        result.put(CorrectnessLevel.Wrong, 0);

        return result;
    }

    private CorrectnessLevel getCorrectness(Digit[] hintDigits, int place, Digit digit) {
        Digit hintDigit = hintDigits[place];
        int hintNumber = hintDigit.getNumber();
        int number = digit.getNumber();

        if (hintNumber == number) {
            return CorrectnessLevel.CorrectAndRightPlace;
        }

        boolean anyMatch = anyMatch(hintDigits, digit);
        if (anyMatch) {
            return CorrectnessLevel.CorrectButWrongPlace;
        }

        return CorrectnessLevel.Wrong;
    }

    private boolean anyMatch(Digit[] hintDigits, Digit digit) {
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
