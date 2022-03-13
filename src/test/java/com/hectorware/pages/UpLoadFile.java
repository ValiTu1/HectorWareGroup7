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
        @FindBy(xpath = "//span[@class='icon icon-add']")
        public WebElement addButton;

        @FindBy(xpath = "//span[.='Upload file']")
        public WebElement uploadFile;

        @FindBy(partialLinkText = "nigth")
        public WebElement uploadedFile;

        @FindBy(xpath = "//tr[@data-file='nigthvision.webp']//td")
        public WebElement uploadedFileSelect;

        @FindBy(linkText = "Actions")
        public WebElement ActionsDropdown;

        @FindBy(xpath = "//span[@class='icon icon-delete']")
        public WebElement actionsDelete;

        @FindBy(id = "view13-input-folder")
        public WebElement newFolderName;

        @FindBy(xpath = "(//input[@type='submit'])[2]")
        public WebElement newFolderArrow;

        @FindBy(xpath = "//tr[@data-file='new Folder new']")
        public WebElement uploadedFolder;

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
            StringSelection str = new StringSelection("nigthvision");
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
        public List<String> getElementsText(List<WebElement> list){
            List<String> elementText = new ArrayList<>();
            for (WebElement element : list) {
                elementText.add(element.getText());
            }
            return elementText;
        }
}
