package com.bduman.cracklock.steps;

import com.bduman.cracklock.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class CrackLockSteps {
    private final CorrectnessEngine correctnessEngine;
    private final ArrayList<Hint> hintList;
    private List<Integer> results;

    public CrackLockSteps() {
        this.correctnessEngine = new CorrectnessEngine();
        this.hintList = new ArrayList<>();
    }

    @Given("{digits} One number is correct and in the right place")
    public void oneNumberIsCorrectAndInTheRightPlace(Digit[] hintDigits) {
        Hint hint = new NNumberInTheRightPlace(hintDigits, 1, correctnessEngine);
        this.hintList.add(hint);
    }

    @Given("{digits} One number is correct but in the wrong place")
    public void oneNumberIsCorrectButInTheWrongPlace(Digit[] hintDigits) {
        Hint hint = new NNumberInTheWrongPlace(hintDigits, 1, correctnessEngine);
        this.hintList.add(hint);
    }

    @Given("{digits} Two numbers are correct but in the wrong place")
    public void twoNumbersAreCorrectButInTheWrongPlace(Digit[] hintDigits) {
        Hint hint = new NNumberInTheWrongPlace(hintDigits, 2, correctnessEngine);
        this.hintList.add(hint);
    }

    @Given("{digits} Nothing is correct")
    public void nothingIsCorrect(Digit[] hintDigits) {
        Hint hint = new NothingIsCorrect(hintDigits, correctnessEngine);
        this.hintList.add(hint);
    }

    @When("Crack lock")
    public void crackLock() {
        Hint[] hints = hintList.toArray(new Hint[0]);
        AndHints andHints = new AndHints(hints);

        // TODO: refactor later
        results = new ArrayList<>();
        for (int i = 100; i < 1000; i++) {
            int d1 = i / 100;
            int d2 = (i % 100) / 10;
            int d3 = (i % 100) % 10;

            Digit[] digits = generateDigits(d1, d2, d3);
            boolean result = andHints.apply(digits);
            if (result) {
                results.add(i);
            }
        }
    }

    @Then("Codes should be {codes}")
    public void CodesShouldBe(int[] expectedCodes) {
        int[] actualCodes = results.stream().mapToInt(Integer::intValue).toArray();
        Assert.assertArrayEquals(expectedCodes, actualCodes);
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
