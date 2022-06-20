package com.bduman.cracklock;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = {"com.bduman"}, features = "src/test/resources/")
public class CucumberRunner {
}
