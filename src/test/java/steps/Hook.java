package steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by denni_6jm52yj on 04-Mar-17.
 */
public class Hook extends BaseUtil {

    private BaseUtil base;

    public Hook(BaseUtil base) {

        this.base = base;
    }

    @Before
    public void InitializeTest() {

        System.out.println("Opening the browser : Chrome");

        System.setProperty("webdriver.chrome.driver", "C:\\libs\\chromedriver.exe");
        base.Driver = new ChromeDriver();


    }


    @After
    public void TearDownTest(Scenario scenario) {
        if (scenario.isFailed()) {

            //take printscreen
            System.out.println(scenario.getName());

        }

        System.out.println("Closing the browser : MOCK");
    }


}
