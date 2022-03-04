package com.hectorware.pages;


import com.hectorware.utilities.Driver;
import com.hectorware.utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class UpLoadFile extends BasePage {
    @FindBy(xpath = "//span[@class=\"icon icon-add\"]")
    public WebElement addButton;

    @FindBy(xpath = "//span[.='Upload file']")
    public WebElement uploadFile;

    @FindBy(xpath = "//div[@class='favorite-mark ']\n")
    public WebElement uploadedFile;

    public void addBtn() {
        addButton.click();
        //uploadFile.click();
    }

    public void uploadOption(String uploadOption) {

        Driver.get().findElement(By.xpath("//span[.='" + uploadOption + "']")).click();
    }

    public void uploadFile() throws AWTException {
        Robot rb = new Robot();
        Utils.wait(6);
        //put path to your image in a clipboard
        StringSelection str = new StringSelection("2");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        // press Contol+V for pasting
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        // release Contol+V for pasting
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        // for pressing and releasing Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

    }
    /*public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }*/
public List<String> getElementsText(List<WebElement> list){
    List<String> elementText = new ArrayList<>();
    for (WebElement element : list) {
        elementText.add(element.getText());
    }
    return elementText;
}
}

