package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;


public class FacebookTestingApp {
    private static final String XPATH_COOKIES = "//button[contains(string(),'Zezwól na')]";
    private static final String XPATH_NEW_ACCOUNT = "//*[@data-testid=\"open-registration-form-button\"]";
    private static final String XPATH_DAY = "//*[@id='day']";
    private static final String XPATH_MONTH = "//*[@id='month']";
    private static final String XPATH_YEAR = "//*[@id='year']";
    private static final String XPATH_WAIT = "//div[contains(@id, 'reg_box')]";


    public static void main(String[] args) {

        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com");
        WebElement cookiesButton = driver.findElement(By.xpath(XPATH_COOKIES));
        cookiesButton.click();
        WebElement newAccountButton = driver.findElement(By.xpath(XPATH_NEW_ACCOUNT));
        newAccountButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        while (!driver.findElement(By.xpath(XPATH_WAIT)).isDisplayed());

        WebElement daySelector = driver.findElement(By.xpath(XPATH_DAY));
        WebElement yearSelector = driver.findElement(By.xpath(XPATH_YEAR));
        WebElement monthSelector = driver.findElement(By.xpath(XPATH_MONTH));

        Select selectDay = new Select(daySelector);
        Select selectYear = new Select(yearSelector);
        Select selectMonth = new Select(monthSelector);

        selectDay.selectByIndex(3);
        selectMonth.selectByIndex(11);
        selectYear.selectByIndex(32);
    }
}
