package com.bduman.cracklock;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        CorrectnessEngine correctnessEngine = new CorrectnessEngine();

        Digit[] firstHintDigits = Digits.generate(690);
        Hint nNumberInTheRightPlace = new NNumberInTheRightPlace(firstHintDigits, 1, correctnessEngine);

        Digit[] secondHintDigits = Digits.generate(741);
        Hint nNumberInTheWrongPlace2 = new NNumberInTheWrongPlace(secondHintDigits, 1, correctnessEngine);

        Digit[] thirdHintDigits = Digits.generate(504);
        Hint nNumberInTheWrongPlace3 = new NNumberInTheWrongPlace(thirdHintDigits, 2, correctnessEngine);

        Digit[] fourthHintDigits = Digits.generate(387);
        Hint nothingIsCorrect = new NothingIsCorrect(fourthHintDigits, correctnessEngine);

        Digit[] fifthHintDigits = Digits.generate(219);
        Hint nNumberInTheWrongPlace5 = new NNumberInTheWrongPlace(fifthHintDigits, 1, correctnessEngine);

        Hint andHints = new AndHints(
                nNumberInTheRightPlace,
                nNumberInTheWrongPlace2,
                nNumberInTheWrongPlace3,
                nothingIsCorrect,
                nNumberInTheWrongPlace5
        );

        // TODO: refactor later
        List<Code> codes = Codes.generate(3);
        for (Code code : codes) {
            Digit[] digits = code.getDigits();
            boolean result = andHints.apply(digits);
            if (result) {
                int number = code.getNumber();
                System.out.println(number);
            }
        }
    }
}