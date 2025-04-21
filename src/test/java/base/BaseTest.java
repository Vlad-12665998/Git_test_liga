package base;

import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.base.BasePage;

public class BaseTest {
    protected WebDriver driver;
    protected BasePage page; // Добавлено

    @BeforeClass
    public void setupClass() {
        driver = Browser.createDriver();
        page = new BasePage(driver); // Инициализация
    }

    @AfterClass
    public void tearDownClass() {
        if (driver != null) {
            driver.quit();
        }
    }
}