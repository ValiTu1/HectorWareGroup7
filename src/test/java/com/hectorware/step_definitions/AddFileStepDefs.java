package com.hectorware.step_definitions;

import com.hectorware.pages.AddFilePage;
import com.hectorware.utilities.Driver;
import com.hectorware.utilities.Utils;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.List;

public class AddFileStepDefs {
    
        AddFilePage addFilePage=new AddFilePage();
        WebDriverWait wait =new WebDriverWait(Driver.get(),10);

    @When("user clicks on plus sign button")
    public void userClicksOnPlusSignButton()  {
         wait.until(ExpectedConditions.elementToBeClickable(addFilePage.plusSign));
         addFilePage.plusSign.click();

    }

    @Then("user should see three options")
    public void userShouldSeeThreeOptions(List<String> expecteAdddFileOptions) {
        List<String>actualAddFileOptions= Utils.getElementsText(addFilePage.addFileOptions);
        Assert.assertEquals(expecteAdddFileOptions,actualAddFileOptions);
    }

    @When("user clicks on {string}")
    public void userClicksOn(String option)  {

        addFilePage.addFileOptions(option);
    }
    @And("user selects a file from directory")
    public void userSelectsAFileFromDirectory() throws AWTException {

        addFilePage.uploadFile();
    }

    @And("user should able to created a {string}")
    public void userShouldAbleToCreatedA(String expectedFileName) {
        expectedFileName="EU7Project";
        Assert.assertTrue(expectedFileName.contains(addFilePage.getFileText.getText()));

    }
    @Then("user should give folder name")
    public void userShouldGiveFolderName() {
         addFilePage.newFolderInput.sendKeys("EU7Project");
    }

    @Then("user should not create new folder same name with existing one and should get error message name {string}")
    public void userShouldNotCreateNewFolderSameNameWithExistingOneAndShouldGetErrorMessageName(String expectedErrorMessage) {
        Assert.assertTrue(addFilePage.errorMessage.getText().contains(expectedErrorMessage));

    }

    @Then("user should give new folder name and click on arrow sign")
    public void userShouldGiveNewFolderNameAndClickOnArrowSign() throws InterruptedException {

        addFilePage.addNewFolder();
    }

    @Then("user should give new text document name and click on arrow sign")
    public void userShouldGiveNewTextDocumentNameAndClickOnArrowSign() {
         ;
        addFilePage.addNewTextDoc();
    }

    @Then("user should give new text document name")
    public void userShouldGiveNewTextDocumentName() {
        addFilePage.newTexDocInputBox.sendKeys("EU7");
    }

    @Then("user should not create new text document same name with existing one and should get error message name {string}")
    public void userShouldNotCreateNewTextDocumentSameNameWithExistingOneAndShoulGetErrorMessageName(String expectedErrorMessage) {
        Assert.assertTrue(addFilePage.errorMessage.getText().contains(expectedErrorMessage));

    }

}
