/**
 * Created by andrewevans on 20/06/2017.
 */

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(format = {"pretty", "html:target/cucumber"})

public class runTest { }
