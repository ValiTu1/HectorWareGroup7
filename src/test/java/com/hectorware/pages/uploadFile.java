package com.hectorware.pages;


import com.hectorware.utilities.Driver;
import com.hectorware.utilities.Utils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.event.KeyEvent;

public class uploadFile extends BasePage{
    @FindBy(xpath = "//span[@class=\"icon icon-add\"]")
    public WebElement addButton;

    @FindBy (xpath = "//span[.='Upload file']")
    public WebElement uploadFile;

    public void addBtn(){
        addButton.click();
        //uploadFile.click();
    }
    public void uploadOption(String uploadOption)  {

        Driver.get().findElement(By.xpath("//span[.='"+ uploadOption + "']")).click();



    }
}

