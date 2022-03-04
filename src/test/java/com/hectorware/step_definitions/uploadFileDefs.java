package com.hectorware.step_definitions;

import com.hectorware.pages.UpLoadFile;
import com.hectorware.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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

    @Then("user selects a file from directory")
    public void userSelectsAFileFromDirectory() throws AWTException {
        upload.uploadFile();

            }
 }

