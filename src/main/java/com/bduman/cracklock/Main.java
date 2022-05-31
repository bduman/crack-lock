package com.bduman.cracklock;

public class Main {
    public static void main(String[] args) {
        Digit[] firstHintDigits = generateDigits(6, 9, 0);
        Hint nNumberIsCorrect = new NNumberIsCorrect(firstHintDigits, 1);
        Hint nNumberInTheRightPlace = new NNumberInTheRightPlace(firstHintDigits, 1);

        Digit[] secondHintDigits = generateDigits(7, 4, 1);
        Hint nNumberIsCorrect2 = new NNumberIsCorrect(secondHintDigits, 1);
        Hint nNumberInTheWrongPlace2 = new NNumberInTheWrongPlace(secondHintDigits, 1);

        Digit[] thirdHintDigits = generateDigits(5, 0, 4);
        Hint nNumberIsCorrect3 = new NNumberIsCorrect(thirdHintDigits, 2);
        Hint nNumberInTheWrongPlace3 = new NNumberInTheWrongPlace(thirdHintDigits, 2);

        Digit[] fourthHintDigits = generateDigits(3, 8, 7);
        Hint nothingIsCorrect = new NothingIsCorrect(fourthHintDigits);

        Digit[] fifthHintDigits = generateDigits(2, 1, 9);
        Hint nNumberIsCorrect5 = new NNumberIsCorrect(fifthHintDigits, 1);
        Hint nNumberInTheWrongPlace5 = new NNumberIsCorrect(fifthHintDigits, 1);

        Hint andHints = new AndHints(
                nNumberIsCorrect,
                nNumberInTheRightPlace,
                nNumberIsCorrect2,
                nNumberInTheWrongPlace2,
                nNumberIsCorrect3,
                nNumberInTheWrongPlace3,
                nothingIsCorrect,
                nNumberIsCorrect5,
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
            int number = numbers[i];
            result[i] = new Digit(number);
        }

        return result;
    }
}