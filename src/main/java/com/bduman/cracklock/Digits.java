package com.bduman.cracklock;

import java.util.LinkedList;

public class Digits {

    public static Digit[] generate(int number) {
        LinkedList<Integer> stack = new LinkedList<>();
        while (number > 0) {
            stack.push(number % 10);
            number = number / 10;
        }

        int size = stack.size();
        Digit[] result = new Digit[size];

        int place = 0;
        while (!stack.isEmpty()) {
            Integer digitNumber = stack.pop();
            Digit digit = Digits.generate(place, digitNumber);
            result[place] = digit;

            place++;
        }

        return result;
    }

    public static Digit generate(int place, int digit) {
        Digit result = new Digit(place, digit);
        return result;
    }
}
