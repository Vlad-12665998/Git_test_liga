package pages.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pages.base.BasePage;

public class DatePickerPage extends BasePage {

    public DatePickerPage(WebDriver driver) {
        super(driver);
    }

    private static final String URL_DATE_PICKER_PAGE = "https://demoqa.com/date-picker";

    private static final String SELECT_DATE_ELEMENT = "//input[@id='datePickerMonthYearInput']";

    private String dayInDatePicker(int number){
        return String.format("//div[@role='option' and text()='%s']",number);
    }

    private static final String MONTH_SELECT = "//select[contains(@class, 'month')]";
    private static final String YEAR_SELECT = "//select[contains(@class, 'year')]";

    private static final String RESULT_DATE_INPUT = "//input[@value='03/12/2024']";


    public void openDatePickerPage(){
        openUrl(URL_DATE_PICKER_PAGE);
    }

    public void clickDatePicker(){
        click(By.xpath(SELECT_DATE_ELEMENT));
    }

    public void selectMonth(String month){
        Select monthSelect = new Select(findElement(By.xpath(MONTH_SELECT)));
        monthSelect.selectByVisibleText(month);
    }

    public void selectYear(String year){
        Select yearSelect = new Select(findElement(By.xpath(YEAR_SELECT)));
        yearSelect.selectByVisibleText(year);
    }

    public void setDate(){
        selectYear("2024");
        selectMonth("March");
        click(By.xpath(dayInDatePicker(12)));
    }

    public boolean isResultDateDisplay(){
        return isElementDisplay(By.xpath(RESULT_DATE_INPUT));
    }
}
