package com.bduman.cracklock.tranformers;

import com.bduman.cracklock.Digit;
import com.bduman.cracklock.Digits;
import io.cucumber.java.ParameterType;

import java.util.Arrays;

public class Transformers {

    @ParameterType(value = "\\[([0-9,]*)\\]")
    public Digit[] digits(String input) {
        int[] numbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue)
                .toArray();

        Digit[] result = new Digit[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            int place = i;
            int number = numbers[i];
            result[i] = Digits.generate(place, number);
        }

        return result;
    }

    @ParameterType(value = "\\[([0-9,]*)\\]")
    public int[] codes(String input) {
        int[] result = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue)
                .toArray();

        return result;
    }
}
