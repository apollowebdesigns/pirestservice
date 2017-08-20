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

public class MapNavSteps {
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

    @Given("^I click button map on navbar '(.*?)'$")
    public void clickNavbarMap(String searchTerm) {
        WebElement searchButton = driver.findElement(By.id("mapnav"));
        searchButton.click();
    }

    @When("^I click the map$")
    public void isItMap() {
        WebElement searchButton = driver.findElement(By.id("mapid"));
        searchButton.click();
    }

    @Then("I can click it as it is there$")
    public void assertSingleResult() {
        System.out.println("Success!");
    }
}
