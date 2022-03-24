package com.hectorware.step_definitions;
import com.hectorware.pages.OnlineStatusPage;
import com.hectorware.utilities.Utils;
import io.cucumber.java.en.*;
import static org.junit.Assert.*;
import java.util.List;

public class OnlineStatusStepDefs {

    OnlineStatusPage onlineStatusPage=new OnlineStatusPage();
    @When("the user clicks the profile icon")
    public void the_user_clicks_the_profile_icon() {
        onlineStatusPage.statusBtn.click();

    }

    @When("the user sees profile drop down icons")
    public void the_user_sees_profile_drop_down_icons() {
        onlineStatusPage.currentStatus.click();
    }

    @When("the user clicks the status bar")
    public void the_user_clicks_the_status_bar() {
        onlineStatusPage.setStatusBtn.click();
    }


    @Then("the user should be able to set Status massage")
    public void the_user_should_be_able_to_set_Status_massage() {
            onlineStatusPage.clickSetStatusMessage();

    }

    @Then("the user should see the following options")
    public void theUserShouldSeeTheFollowingOptions(List<String> expectedStatusOptions) {
        assertEquals(expectedStatusOptions, onlineStatusPage.getStatusOptions());
    }

    @And("the user clicks the {string} status option")
    public void theUserClicksTheStatusOption(String statusOption) {
        onlineStatusPage.selectStatusByName("Away");
    }

    @Then("the status should be changed to {string}")
    public void theStatusShouldBeChangedTo(String status) {
        assertEquals(onlineStatusPage.currentStatus.getAttribute("outerText").trim(), status);
    }

    @And("the user sees the following status message options")
    public void theUserSeesTheFollowingStatusMessageOptions(List<String> expectedOptions) {
        assertEquals(expectedOptions, onlineStatusPage.getStatusMessages());
    }

    @When("the user clicks the {string} status message options")
    public void theUserClicksTheStatusMessageOptions(String statusMessage) {
        Utils.waitFor(1);
        onlineStatusPage.selectStatusMessageByName(statusMessage);
    }
}

