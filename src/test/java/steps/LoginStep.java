package steps;

import Base.BaseUtil;
import cucumber.api.PendingException;
import transformations.EmailTransform;
import transformations.SalaryCountTransformer;
import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by denni_6jm52yj on 04-Mar-17.
 */
public class LoginStep extends BaseUtil {

    private BaseUtil base;

    public LoginStep(BaseUtil base) {
        this.base = base;
    }

    @And("^I click login button$")
    public void iClickLoginButton() throws Throwable {

        LoginPage page = new LoginPage(base.Driver);
        page.ClickLogin();

    }

    @Given("^I navigate to the login page of the application$")
    public void iNavigateToTheLoginPageOfTheApplication() throws Throwable {
        System.out.println("Navigate to login page");
        base.Driver.navigate().to("http://www.executeautomation.com/demosite/Login.html");
    }

    @Then("^I should see the userform page$")
    public void iShouldSeeTheUserformPage() throws Throwable {
        Assert.assertEquals(base.Driver.findElement(By.id("Initial")).isDisplayed(),true);
    }


    @And("^I enter the following credentials$")
    public void iEnterTheFollowingCredentials(DataTable table) throws Throwable {
        // Create an arraylist
        List<User> users = new ArrayList<User>();
        // Store all users
        users = table.asList(User.class);

        LoginPage page = new LoginPage(base.Driver);

        for (User user : users) {
            page.Login(user.username, user.password);
        }
    }

    @And("^I enter the ([^\"]*) and ([^\"]*)$")
    public void iEnterTheUsernameAndPassword(String userName, String passWord) throws Throwable {
        System.out.println("The username is " + userName);
        System.out.println("The password is " + passWord);
    }

    @And("^I enter the users email address as Email:([^\"]*)$")
    public void iEnterTheUsersEmailAddressAsEmailAdmin(@Transform(EmailTransform.class) String email) throws Throwable {
        System.out.println("The email is " + email);
    }

    @And("^I verify the count of my salary digits for Rs (\\d+)$")
    public void iVerifyTheCountOfMySalaryDigitsForRs(@Transform(SalaryCountTransformer.class) int salary) throws Throwable {
        System.out.println("My salary digits count is " + salary);
    }

    @Then("^I should see the userform page wrongly$")
    public void iShouldSeeTheUserformPageWrongly() throws Throwable {
        Assert.assertEquals(base.Driver.findElement(By.id("Unknown")).isDisplayed(),true);
    }


    public class User {
        public String username;
        public String password;

        public User(String userName, String passWord) {
            username = userName;
            password = passWord;
        }
    }
}
