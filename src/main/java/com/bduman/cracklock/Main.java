package com.bduman.cracklock;

public class Main {
    public static void main(String[] args) {
        CorrectnessEngine correctnessEngine = new CorrectnessEngine();

        Digit[] firstHintDigits = generateDigits(6, 9, 0);
        Hint nNumberInTheRightPlace = new NNumberInTheRightPlace(firstHintDigits, 1, correctnessEngine);

        Digit[] secondHintDigits = generateDigits(7, 4, 1);
        Hint nNumberInTheWrongPlace2 = new NNumberInTheWrongPlace(secondHintDigits, 1, correctnessEngine);

        Digit[] thirdHintDigits = generateDigits(5, 0, 4);
        Hint nNumberInTheWrongPlace3 = new NNumberInTheWrongPlace(thirdHintDigits, 2, correctnessEngine);

        Digit[] fourthHintDigits = generateDigits(3, 8, 7);
        Hint nothingIsCorrect = new NothingIsCorrect(fourthHintDigits, correctnessEngine);

        Digit[] fifthHintDigits = generateDigits(2, 1, 9);
        Hint nNumberInTheWrongPlace5 = new NNumberInTheWrongPlace(fifthHintDigits, 1, correctnessEngine);

        Hint andHints = new AndHints(
                nNumberInTheRightPlace,
                nNumberInTheWrongPlace2,
                nNumberInTheWrongPlace3,
                nothingIsCorrect,
                nNumberInTheWrongPlace5
        );

        for (int i = 100; i < 1000; i++) {
            int d1 = i / 100;
            int d2 = (i % 100) / 10;
            int d3 = (i % 100) % 10;

            Digit[] digits = generateDigits(d1, d2, d3);
            boolean result = andHints.apply(digits);
            if (result) {
                System.out.println(i);
            }
        }

    }

    private static Digit[] generateDigits(int... numbers) {
        Digit[] result = new Digit[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            int place = i;
            int number = numbers[i];
            result[i] = new Digit(place, number);
        }

        return result;
    }
}