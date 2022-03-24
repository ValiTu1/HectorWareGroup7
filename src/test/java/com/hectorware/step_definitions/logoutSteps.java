package com.hectorware.step_definitions;

import com.hectorware.utilities.ConfigurationReader;
import com.hectorware.utilities.ConfigurationReader;
import com.hectorware.utilities.Driver;
import com.hectorware.utilities.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

public class logoutSteps {

    @Given("Navigate to webpage")
    public void navigate_to_webpage() {
        Driver.get().get(ConfigurationReader.get("url"));

    }

    @Then("Verify login page is displayed")
    public void verify_login_page_is_displayed() {
        Utils.wait(5);
        String exptectedTitle = "Hectorware - QA";
        String actualtitle = Driver.get().getTitle();
        Assert.assertEquals("User is not on the login page", exptectedTitle, actualtitle);

    }


    @Then("Verify profile window is displayed")
    public void verify_profile_window_is_displayed() {
        Utils.wait(5);
        String exptectedTitle = "Files - Hectorware - QA";
        String actualtitle = Driver.get().getTitle();
        Assert.assertEquals("User is not on the index page", exptectedTitle, actualtitle);
    }

    @Then("Click on settings button")
    public void click_on_settings_button() {
        Driver.get().findElement(By.xpath("//*[@id='expand']/div[1]/img")).click();
    }

    @Then("Verify options are displayed")
    public void verify_options_are_displayed() {
        String expectedSettingTitle = "Mike S";
        String Setting_button = "//span[@title='Mike S']";
        String actualSettingTitle = Driver.get().findElement(By.xpath(Setting_button)).getAttribute("outerText");

        Assert.assertEquals("Setting title is not correct", expectedSettingTitle, actualSettingTitle);

    }

    @Then("Click on Log out button")
    public void click_on_Log_out_button() {
        Driver.get().findElement(By.xpath("//*[@id='expanddiv']/ul/li[5]/a")).click();
    }

    @Then("Verify that user logged out and lands on login page")
    public void verify_that_user_logged_out_and_lands_on_login_page() {
        Utils.wait(6);
        String exptectedTitle = "Hectorware - QA";
        String actualtitle = Driver.get().getTitle();
        Assert.assertEquals("User is not on the index page", exptectedTitle, actualtitle);
    }





}
