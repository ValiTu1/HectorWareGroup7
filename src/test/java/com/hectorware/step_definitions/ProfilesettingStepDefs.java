package com.hectorware.step_definitions;

import com.hectorware.pages.ProfileSettingsPage;
import com.hectorware.utilities.Driver;
import com.hectorware.utilities.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilesettingStepDefs {

    ProfileSettingsPage profileSettingsPage=new ProfileSettingsPage();
    WebDriverWait webDriverWait =new WebDriverWait(Driver.get(),10);
    Actions actions= new Actions(Driver.get());


    @And("user navigates to {string}")
    public void userNavigatesTo(String dropdownmenu) {
        profileSettingsPage.dropdown.click();
        Utils.wait(1);

    }

    @And("user select {string} option")
    public void userSelectOption(String settingsoptn) {
        profileSettingsPage.settings.click();
        Utils.wait(2);
    }

    @Then("the {string} page should be displayed")
    public void thePageShouldBeDisplayed(String profilesettings) {
        String actualTitle=Driver.get().getTitle();
        Assert.assertTrue(actualTitle.contains(profilesettings));


    }

    @When("user click on select avatar button")
    public void userClickOnSelectAvatarButton() {
        profileSettingsPage.selectedavatar.click();
        Utils.wait(2);

    }

    @Then("user choose the picture")
    public void userChooseThePicture() {
        profileSettingsPage.selectedpicture.click();
        Utils.wait(4);

    }


    @And("user click on Choose as a profile picture")
    public void userClickOnChooseAsAProfilePicture() {
        profileSettingsPage.choosebtn.click();
        Utils.wait(7);

    }

    @And("user crop the picture and click the button")
    public void userCropThePictureAndClickTheButton() {
        profileSettingsPage.croppedpic.click();
    }
}
