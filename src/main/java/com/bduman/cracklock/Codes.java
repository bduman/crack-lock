package com.bduman.cracklock;

import java.util.ArrayList;
import java.util.List;

public class Codes {

    public static List<Code> generate(int placeCount) {
        int initialNumber = (int) Math.pow(10, placeCount - 1);
        int maxNumber = (int) Math.pow(10, placeCount);

        List<Code> result = new ArrayList<>();
        for (int i = initialNumber; i < maxNumber; i++) {
            Digit[] digits = Digits.generate(i);
            Code code = new Code(digits);
            result.add(code);
        }

        return result;
    }
}
