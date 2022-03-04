package com.hectorware.step_definitions;
import com.hectorware.pages.OnlineStatusPage;
import com.hectorware.utilities.Utils;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;

public class OnlineStatusStepDefs {

    OnlineStatusPage onlineStatusPage=new OnlineStatusPage();
    @When("the user clicks the profile icon")
    public void the_user_clicks_the_profile_icon() {
        onlineStatusPage.OnlineStatus.click();

    }

    @When("the user sees profile drop down icons")
    public void the_user_sees_profile_drop_down_icons() {
        onlineStatusPage.InAmeetingButton.click();
    }

    @And("the user should see {string}")
    public void theUserShouldSee(List <String>ExpectedOptions)
    {
        List<String>actualOption= Utils.getElementsText(onlineStatusPage.statusOptions);
        System.out.println("actualOption = " + actualOption);
        System.out.println("ExpectedOptions = " + ExpectedOptions);


        Assert.assertTrue(ExpectedOptions.contains(actualOption));
    }

    @When("the user clicks the status bar")
    public void the_user_clicks_the_status_bar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the user should be able view Online Status")
    public void the_user_should_be_able_view_Online_Status() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user sees four different status options")
    public void the_user_sees_four_different_status_options() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user clicks the “Away” status option")
    public void the_user_clicks_the_Away_status_option() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the user should be able change Online Status")
    public void the_user_should_be_able_change_Online_Status() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user is on the status setting page")
    public void the_user_is_on_the_status_setting_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user sees five different status message options")
    public void the_user_sees_five_different_status_message_options() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user clicks the “in a meeting” status message options")
    public void the_user_clicks_the_in_a_meeting_status_message_options() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the user should be able to set Status massage")
    public void the_user_should_be_able_to_set_Status_massage() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}

