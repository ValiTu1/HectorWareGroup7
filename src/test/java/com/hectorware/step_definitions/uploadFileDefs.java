package com.hectorware.step_definitions;

import com.hectorware.pages.UpLoadFile;
import com.hectorware.utilities.Driver;
import com.hectorware.utilities.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class uploadFileDefs {
    UpLoadFile upload = new UpLoadFile();

    @Then("user clicks addButton")
    public void userClicksAddButton() {
        upload.addBtn();

    }
    @And("user chooses {string} option")
    public void userChoosesOption(String uploadOption) {
        upload.uploadOption(uploadOption);
    }

    @Then("user selects uploaded file from directory")
    public void userSelectsUploadedFileFromDirectory() throws AWTException {

        upload.uploadFile();
        Utils.wait(5);
        Assert.assertTrue("file is not uploaded", upload.uploadedFile.isDisplayed());
        Utils.wait(7);
        upload.uploadedFileSelect.click();
        upload.ActionsDropdown.click();
        upload.actionsDelete.click();

        //Assert.assertTrue("file is not deleted", upload.uploadedFile.isDisplayed());

    }

    @Then("user creates New folder in the page")
    public void userCreatesNewFolderInThePage() {

        Utils.wait(4);
        upload.newFolderName.sendKeys("new Folder new");
        Utils.wait(3);
        upload.newFolderArrow.click();
        Utils.wait(4);

        Assert.assertTrue("uploaded file is not seen", upload.uploadedFolder.isDisplayed());

        // to delete the uploaded folder
        Driver.get().findElement(By.xpath("//tr[@data-file='new Folder new']/td")).click();
        upload.ActionsDropdown.click();
        upload.actionsDelete.click();

    }
}
