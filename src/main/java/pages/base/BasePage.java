package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    public WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    private static final By NAME_PAGE = By.xpath("//h1[@class='text-center']");

    /**
     * Перейти по url
     * @param url ссылка в виде строки
     */
    public void openUrl(String url){
        driver.get(url);
    }

    /**
     * Найти элемент на странице
     * @param locator путь до элемента, тип - By
     * @return element найденный элемент
     */
    public WebElement findElement(By locator){
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        return element;
    }

    public List<WebElement> findElements(String locator){
        return driver.findElements(By.xpath(locator));
    }

    public String getText(By locator){
        return findElement(locator).getText();
    }

    public String getPageName(){
        return getText(NAME_PAGE);
    }

    public boolean isElementEnabled(By locator){
        return findElement(locator).isEnabled();
    }

    public void clear(By locator){
        findElement(locator).clear();
    }

    public void sendKeys(By locator, String text){
        findElement(locator).sendKeys(text);
    }

    public void click(By locator){
        findElement(locator).click();
    }

    public boolean isElementDisplay(By locator){
        try {
            return findElement(locator).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public void waitElementIsDisplay(By locator, int seconds){
        new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(driver1 -> isElementDisplay(locator));
    }
}