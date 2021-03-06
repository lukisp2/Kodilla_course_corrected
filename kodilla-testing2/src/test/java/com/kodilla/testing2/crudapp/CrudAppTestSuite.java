package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CrudAppTestSuite {
    private final static String BASE_URL = "https://lukisp2.github.io";
    private WebDriver driver;
    private Random generator;

    @BeforeEach
    private void initTests() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        generator = new Random();
    }

    @AfterEach
    public void cleanUpAfterTest() {
        driver.close();
    }

    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@action,\"createTask\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[contains(@action,\"createTask\")]/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "//form[contains(@action,\"createTask\")]/fieldset[3]/button";
        String taskName = "Task number" + generator.nextInt(100000) + " to de deleted";
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath((XPATH_TASK_NAME)));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();
        Thread.sleep(2000);
        return taskName;
    }

    private void sentTestTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed()) ;

        driver.findElements(
                        By.xpath("//form[@class=\"datatable__row\"]")).stream()           // [3]
                .filter(anyForm ->                                             // [4]
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]")) // [5]
                                .getText().equals(taskName))                        // [6]
                .forEach(theForm -> {                                          // [7]
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));    // [8]
                    Select select = new Select(selectElement);                 // [9]
                    select.selectByIndex(2);                                   // [10]

                    WebElement buttonCreateCard =                              // [11]
                            theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]")); // [12]
                    buttonCreateCard.click();                                  // [13]
                });
        Thread.sleep(15000);
    }


    private boolean checkTaskExistInTrello(String taskName) throws InterruptedException {
        final String TRELLO_URL = "https://trello.com/login";
        boolean result = false;
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driverTrello.get(TRELLO_URL);

        driverTrello.findElement(By.id("user")).sendKeys("lukaszmarchelelk@gmail.com");
        driverTrello.findElement(By.id("password")).sendKeys("haslo_kodilla");
        WebElement el = driverTrello.findElement(By.id("login"));
        el.submit();

        Thread.sleep(5000);

        driverTrello.findElement(By.id("password")).sendKeys("haslo_kodilla");
        driverTrello.findElement(By.id("login-submit")).submit();

        Thread.sleep(5000);

        driverTrello.findElements(By.xpath("//a[@class=\"board-title\"]")).stream()  // [9]
                .filter(aHref -> aHref.findElements(By.xpath(".//div[@title=\"Kodilla Application\"]")).size() > 0)  // [10]
                .forEach(WebElement::click);                                                // [11]

        Thread.sleep(4000);                                                            // [12]

        result = driverTrello.findElements(By.xpath("//span")).stream()                // [13]
                .anyMatch(theSpan -> theSpan.getText().equals(taskName));                    // [14]

        driverTrello.close();                                                        // [15]

        return result;
    }


    @Test
    void shouldCreateTrelloCard() throws InterruptedException, AWTException {

        String taskName = createCrudAppTestTask();
        sentTestTaskToTrello(taskName);
        //  assertTrue(checkTaskExistInTrello(taskName));
    }


}
