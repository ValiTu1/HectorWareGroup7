package com.hectorware.step_definitions;

import com.hectorware.pages.uploadFile;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.awt.*;

public class uploadFileDefs {
    uploadFile upload = new uploadFile();

    @Then("user clicks addButton")
    public void userClicksAddButton() {
        upload.addBtn();

    }


    @And("user chooses {string} option")
    public void userChoosesOption(String uploadOption) {
        upload.uploadOption(uploadOption);
    }
}
