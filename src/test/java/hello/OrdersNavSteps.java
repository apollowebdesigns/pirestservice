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

import java.io.IOException;

public class OrdersNavSteps {
    private WebDriver driver;

    @Before
    public void before() throws IOException {
        Runtime.getRuntime().exec("mvn spring-boot:run -Dserver.port=9876");
        driver = new FirefoxDriver();
        driver.navigate().to("http://localhost:9876");
    }

    @After
    public void after() {
        driver.quit();
    }

    //Run server instance first, use wiremock?

    @Given("^I want to go to the orders page$")
    public void clickNavbarMap() {
        WebElement searchButton = driver.findElement(By.id("ordersnav"));
    }

    @When("^I click the Move! about button$")
    public void isItMap() {
        WebElement searchButton = driver.findElement(By.id("ordersnav"));
        searchButton.click();
    }

    @Then("I should be on the orders page$")
    public void assertSingleResult() {
        WebElement logo = driver.findElement(By.id("heading"));
        assert(logo.getText().equals("Orders people!"));
    }
}
