package com.framework;

import com.framework.utils.JsonReader;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Map;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.framework.stepdefinitions",
        plugin = {"pretty", "html:target/cucumber-report.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
    public static WebDriver driver;
    public static Map<String, String> testData;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        testData = JsonReader.readJson("src/test/resources/testdata.json");
    }

    @AfterClass
    public static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
