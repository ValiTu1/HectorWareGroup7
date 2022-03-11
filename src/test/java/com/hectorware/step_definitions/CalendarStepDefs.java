package com.hectorware.step_definitions;

import com.hectorware.pages.CalendarPage;
import com.hectorware.utilities.ConfigurationReader;
import com.hectorware.utilities.Driver;
import com.hectorware.utilities.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import javax.swing.text.DateFormatter;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class CalendarStepDefs {
    CalendarPage calendarPage = new CalendarPage();
    WebDriver driver;
    CalendarPage logiNPage = new CalendarPage();

    @When("user clicks on hamburger button")
    public void userClicksOnHamburgerButton() {
        Utils.wait(5);
        calendarPage.hamburgerButton.click();

    }

    @And("user clicks on daily calendar button")
    public void userClicksOnDailyCalendarButton() {
        Utils.wait(5);
        calendarPage.dayButton.click();


    }

    @Then("user should be on the daily calendar")
    public void userShouldBeOnTheDailyCalendar() {
        Utils.wait(5);

        Assert.assertTrue(Driver.get().getTitle().contains(Utils.getLocalDate()));


    }


    @And("user clicks on weekly calendar button")
    public void userClicksOnWeeklyCalendarButton() {
        Utils.wait(5);
        calendarPage.weekButton.click();

    }

    @And("user clicks on monthly calendar button")
    public void userClicksOnMonthlyCalendarButton() {
        Utils.wait(5);
        calendarPage.monthButton.click();
    }

    @Then("user should be on the weekly calendar")
    public void userShouldBeOnTheWeeklyCalendar() {

    }

    @Then("user should be on the monthly calendar")
    public void userShouldBeOnTheMonthlyCalendar() {
    }
}
