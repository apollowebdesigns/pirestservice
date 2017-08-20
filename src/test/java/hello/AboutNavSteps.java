package hello;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AboutNavSteps {
    private WebDriver driver;

    @Before
    public void before() {
        driver = new FirefoxDriver();
        driver.navigate().to("http://localhost:9876");
    }

    @After
    public void after() {
        driver.quit();
    }

    //Run server instance first, use wiremock?

    @Given("^I want to go to the about page$")
    public void clickNavbarMap() {
        WebElement searchButton = driver.findElement(By.id("aboutnav"));
    }

    @When("^I click the nav about button$")
    public void isItMap() {
        WebElement searchButton = driver.findElement(By.id("aboutnav"));
        searchButton.click();
    }

    @Then("I should be on the about page$")
    public void assertSingleResult() {
        WebElement logo = driver.findElement(By.id("logo-container"));
        assert(logo.getText().equals("Raspberry Pi"));
    }
}
