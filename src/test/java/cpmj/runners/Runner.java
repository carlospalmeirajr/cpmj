package cpmj.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/resources/features/",
		glue = { "cpmj" },
		tags = { "@comprar_produto" },
		plugin = { "pretty", "html:target/cucumber-html-report", "json:target/cucumber.json" },
		monochrome = true,
		snippets =  SnippetType.CAMELCASE, 
		dryRun = false,
		strict = true
		)	

public class Runner {
	
}
