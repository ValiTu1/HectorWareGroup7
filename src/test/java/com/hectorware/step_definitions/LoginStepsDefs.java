package com.hectorware.step_definitions;

import com.hectorware.pages.LoginPage;
import com.hectorware.utilities.ConfigurationReader;
import com.hectorware.utilities.Driver;
import com.hectorware.utilities.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;




public class LoginStepsDefs {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("user enters valid username {string} and password {string}")
    public void user_enters_valid_username_and_password(String username, String password) {
        Utils.waitFor(3);
        loginPage.login(username, password);
    }

    @Then("index page should be displayed")
    public void index_page_should_be_displayed() {
        Utils.wait(5);
        String exptectedTitle = "Files - Hectorware - QA";
        String actualtitle = Driver.get().getTitle();
        Assert.assertEquals("User is not on the index page", exptectedTitle, actualtitle);
    }
}
