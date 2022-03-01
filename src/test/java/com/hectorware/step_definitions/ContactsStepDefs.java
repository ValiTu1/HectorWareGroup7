package com.hectorware.step_definitions;

import com.hectorware.pages.ContactsPage;
import com.hectorware.utilities.Driver;
import com.hectorware.utilities.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactsStepDefs {

    ContactsPage contactsPage = new ContactsPage();
    WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
    Actions actions = new Actions(Driver.get());

    @Given("user navigates to {string} page")
    public void user_navigates_to_page(String tabName) {
        wait.until(ExpectedConditions.invisibilityOf(contactsPage.loader));
        contactsPage.navigateMenuTab(tabName);
    }

    @Given("user is on the {string} page")
    public void user_is_on_the_page(String pageTitle) {
        Assert.assertTrue(Driver.get().getTitle().contains(pageTitle));
    }

    @When("user clicks on new group button")
    public void userClicksOnNewGroupButton() {
        Utils.wait(1);
        contactsPage.newGroupBtn.click();
    }

    @And("user enters group name {string}")
    public void userEntersValidGroupName(String groupName) {
        contactsPage.enterGroupName(groupName);
    }

    @And("user clicks to create the new group")
    public void userClicksToCreateTheNewGroup() {
        Utils.wait(1);
        contactsPage.createGroupArrowBtn.click();
    }

    @Then("{string} group should be displayed")
    public void groupShouldBeDisplayed(String groupName) {
        Assert.assertTrue(contactsPage.isGroupCreated(groupName));
    }

    @Then("{string} should be displayed")
    public void shouldBeDisplayed(String error) {
        Utils.waitForPageToLoad(5);
        wait.until(ExpectedConditions.visibilityOf(contactsPage.newGroupErrorMessage));
        Assert.assertTrue(contactsPage.newGroupErrorMessage.isDisplayed());
    }

    @When("user clicks on create new contact button")
    public void userClicksOnCreateNewContactButton() {
        Utils.waitFor(1);
        Utils.waitForVisibility(contactsPage.newContactBtn, 5);
        contactsPage.newContactBtn.click();
    }

    @And("user enters contact details {string}")
    public void userEntersContactDetails(String companyName) {contactsPage.addContactDetails(companyName, "SDET", "0116254535", "vali@cydeo.com",
            "1591", "Du cane Road", "132", "W162NW", "London", "London", "Uk");

    }

    @And("user assigns the contact to a group {string}")
    public void userAssignsTheContactToAGroup(String groupName) {
        Utils.waitFor(1);
        contactsPage.addContactInGroupDropdown.click();
        contactsPage.selectFromListOfOptions(groupName);
        actions.sendKeys(Keys.ENTER);
        Utils.waitFor(3);
    }

    @Then("new contact {string} will be displayed as part of the selected group {string}")
    public void newContactWillBeDisplayedAsPartOfTheSelectedGroup(String companyName,String groupName) {
        contactsPage.selectGroup(groupName);
        Assert.assertTrue(contactsPage.isContactDisplayed(companyName));
    }

    @When("user select a contact {string}")
    public void userSelectAContact(String contactName) {
        contactsPage.selectContact(contactName);
    }

    @And("user is editing a property {string}")
    public void userIsEditingAProperty(String propertyName) {
        contactsPage.editContactDetails(propertyName, "567543");
    }

    @Then("new property {string} should be displayed")
    public void newPropertyShouldBeDisplayed(String propertyName) {
        Assert.assertTrue(contactsPage.isPropertyValueDisplayed(propertyName, "567543"));
    }

    @And("user clicks on the contact dropdown menu")
    public void userClicksOnTheContactMenu() {
        contactsPage.dottedMenuBtn.click();
        Utils.waitFor(3);
    }

    @And("user clicks on Delete button")
    public void userClickOnButton() {
        wait.until(ExpectedConditions.visibilityOf(Driver.get().findElement(By.cssSelector(".popover.vue-popover-theme.open"))));
        Utils.waitForVisibility(contactsPage.deleteButton, 5);
        Utils.waitForClickablility(contactsPage.deleteButton, 5);
        contactsPage.deleteButton.click();
    }

    @Then("Contact {string} should be deleted")
    public void contactShouldBeDeleted(String contactName) {
    }
}
