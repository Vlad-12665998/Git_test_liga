package pages.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class CheckBoxPage extends BasePage {

    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    private static final String URL_CHECK_BOX_PAGE = "https://demoqa.com/checkbox";

    private static final String CHECK_BOX_INPUT_XPATH = "//input[@type='checkbox'][following-sibling::span[text()='%s']]";

    private static final String CHECK_BOX_XPATH = CHECK_BOX_INPUT_XPATH + "/following-sibling::span[@class='rct-checkbox']";

    private static final String BUTTON_TOGGLE = CHECK_BOX_INPUT_XPATH + "/../preceding-sibling::button[@title='Toggle']";

    public void openCheckBoxPage(){
        openUrl(URL_CHECK_BOX_PAGE);
    }

    public boolean getCheckBoxState(String checkBoxName){
        return findElement(By.xpath(String.format(CHECK_BOX_INPUT_XPATH, checkBoxName))).isSelected();
    }

    public void setCheckBox(String checkBoxName, boolean state){
        if (!getCheckBoxState(checkBoxName) == state){
            click(By.xpath(String.format(CHECK_BOX_XPATH, checkBoxName)));
        }
    }

    public boolean isCheckBoxDisplay(String checkBoxName){
        return isElementDisplay(By.xpath(String.format(CHECK_BOX_XPATH, checkBoxName)));
    }

    public void openListCheckBox(String checkBoxName){
        if (isCheckBoxDisplay(checkBoxName)){
            click(By.xpath(String.format(BUTTON_TOGGLE, checkBoxName)));
        }
    }
}