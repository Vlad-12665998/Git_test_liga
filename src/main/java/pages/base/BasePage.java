package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.time.LocalDate;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // Основные методы
    public void openUrl(String url) {
        driver.get(url);
    }

    public void type(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public String getValue(By locator) {
        return driver.findElement(locator).getAttribute("value");
    }

    public void selectByVisibleText(By locator, String text) {
        new Select(driver.findElement(locator)).selectByVisibleText(text);
    }

    public void selectFromDatalist(By inputLocator, String value) {
        WebElement input = driver.findElement(inputLocator);
        input.sendKeys(value);
        // Для datalist может потребоваться дополнительный клик на опции
    }

    public void setCheckbox(By locator, boolean enable) {
        WebElement checkbox = driver.findElement(locator);
        if (checkbox.isSelected() != enable) {
            checkbox.click();
        }
    }

    public boolean isElementSelected(By locator) {
        return driver.findElement(locator).isSelected();
    }

    public void setRadio(By locator) {
        driver.findElement(locator).click();
    }

    public void setDate(By locator, LocalDate date) {
        String formattedDate = String.format("%02d/%02d/%04d", date.getMonthValue(), date.getDayOfMonth(), date.getYear());
        driver.findElement(locator).sendKeys(formattedDate);
    }

    public void setColor(By locator, String hexColor) {
        driver.findElement(locator).sendKeys(hexColor);
    }

    public void setRangeToMax(By locator) {
        WebElement range = driver.findElement(locator);
        range.clear();
        range.sendKeys("100"); // Предполагаем, что максимум = 100
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }
}





