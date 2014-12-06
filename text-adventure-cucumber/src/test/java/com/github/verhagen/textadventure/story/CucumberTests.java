package com.github.verhagen.textadventure.story;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//, tags = { "@failing" }
//@Cucumber.Options(format = { "pretty", "html:target/cucumber" }, features = { "src/test/cucumber/" }, tags = { "@smoke" })
@cucumber.api.CucumberOptions(plugin = { "pretty", "html:target/cucumber" }, features = { "src/cucumber/" })
public class CucumberTests {

}
