package com.hectorware.step_definitions;

import com.hectorware.pages.AddFilePage;
import com.hectorware.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.List;

public class AddFileStepDefs {
    
        AddFilePage addFilePage=new AddFilePage();
        WebDriverWait wait =new WebDriverWait(Driver.get(),10);

  /* *//* @And("user navigates to Files page")
    public void userNavigatesToFilesPage() {
        addFilePage.loginFilePage();
    }*//*
    @And("user navigatess to {string} page")
    public void userNavigatessToPage(String arg0) {
        addFilePage.navigateMenuTab("Files");
    }*/

    @When("user clicks on plus sign button")
    public void userClicksOnPlusSignButton()  {
         wait.until(ExpectedConditions.elementToBeClickable(addFilePage.plusSign));
         addFilePage.plusSign.click();

    }

    @Then("user should see three options")
    public void userShouldSeeThreeOptions(List<String> expecteAdddFileOptions) {
        List<String> actualAddFileOptions=addFilePage.getElementsText(addFilePage.addFileOptions);
        Assert.assertEquals(expecteAdddFileOptions,actualAddFileOptions);
    }

    @When("user clicks on {string}")
    public void userClicksOn(String option)  {
        addFilePage.addFileOptions(option);
    }

    @Then("user should able to download a file")
    public void userShouldAbleToDownloadAFile() throws AWTException {
        addFilePage.uploadFile();
    }
    @Then("user should give folder name")
    public void userShouldGiveFolderName() {
        addFilePage.newFolderInput.sendKeys("EU7Project");
    }
    @Then("user should not create new folder same name with existing one and should get error message name {string}")
    public void userShouldNotCreateNewFolderSameNameWithExistingOneAndShouldGetErrorMessageName(String expectedErrorMessage) {
        Assert.assertTrue(addFilePage.folderErrorMessage.getText().contains(expectedErrorMessage));
        System.out.println(addFilePage.newTexDocInputBox.getText());
    }

    @Then("user should give new folder name and click on arrow sign")
    public void userShouldGiveNewFolderNameAndClickOnArrowSign() throws InterruptedException {

        addFilePage.addNewFolder();
    }

    @Then("user should give new text document name and click on arrow sign")
    public void userShouldGiveNewTextDocumentNameAndClickOnArrowSign() {
        addFilePage.addNewTextDoc();
    }

    @Then("user should give new text document name")
    public void userShouldGiveNewTextDocumentName() {
        addFilePage.newTexDocInputBox.sendKeys("EU7");
    }

    @Then("user should not create new text document same name with existing one and should get error message name {string}")
    public void userShouldNotCreateNewTextDocumentSameNameWithExistingOneAndShoulGetErrorMessageName(String expectedErrorMessage) {
        Assert.assertTrue(addFilePage.textErrorMessage.getText().contains(expectedErrorMessage));
        System.out.println(addFilePage.textErrorMessage.getText());
    }








   /* @Then("user should not able to download exe file and should get {string}")
    public void userShouldNotAbleToDownloadExeFileAndShouldGet(String expectedErrorMessage) throws AWTException, InterruptedException {
        addFilePage.uploadExeFile();

        expectedErrorMessage="expectedErrorMessage";
        Driver.get().manage().timeouts().implicitlyWait(3,TimeUnit.MINUTES);
        Assert.assertEquals(expectedErrorMessage,addFilePage.errorMessage.getText());
    }*/
}
