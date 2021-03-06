package hello;

/**
 * Created by andrewevans on 18/08/2017.
 */


import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertFalse;

public class StepsClass {

    private WebDriver driver;

    @Before
    public void before() {
        driver = new FirefoxDriver();
        driver.navigate().to("http://en.wikipedia.org");
    }

    @After
    public void after() {
        driver.quit();
    }

    @Given("^Enter search term '(.*?)'$")
    public void searchFor(String searchTerm) {
        WebElement searchField = driver.findElement(By.id("searchInput"));
        searchField.sendKeys(searchTerm);
    }

    @When("^Do search$")
    public void clickSearchButton() {
        WebElement searchButton = driver.findElement(By.id("searchButton"));
        searchButton.click();
    }

    @Then("^Single result is shown for '(.*?)'$")
    public void assertSingleResult(String searchResult) {
        WebElement results = driver
                .findElement(By.cssSelector("div#mw-content-text.mw-content-ltr p"));
        assertFalse(results.getText().contains(searchResult + " may refer to:"));
        assertTrue(results.getText().startsWith(searchResult));
    }
}