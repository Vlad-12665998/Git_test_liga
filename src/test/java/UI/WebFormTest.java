package UI;


import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.LocalDate;

public class WebFormTest extends BaseTest {

    private static final String FORM_URL = "https://www.selenium.dev/selenium/web/web-form.html";

    // Локаторы
    private static final By TEXT_INPUT = By.name("my-text");
    private static final By TEXTAREA = By.name("my-textarea");
    private static final By PASSWORD = By.name("my-password");
    private static final By DROPDOWN = By.name("my-select");
    private static final By DATALIST_INPUT = By.name("my-datalist");
    private static final By CHECKBOX_1 = By.id("my-check-1");
    private static final By CHECKBOX_2 = By.id("my-check-2");
    private static final By RADIO_2 = By.id("my-radio-2");
    private static final By SUBMIT_BUTTON = By.cssSelector("button");
    private static final By MESSAGE = By.id("message");
    private static final By DATE_PICKER = By.name("my-date");
    private static final By COLOR_PICKER = By.name("my-colors");
    private static final By RANGE = By.name("my-range");

    @Test
    public void testWebFormSubmission() {
        // 1. Открываем страницу
        page.openUrl(FORM_URL);

        // 2. Заполняем текстовые поля
        page.type(TEXT_INPUT, "Сазонов Владимир Владимирович");
        page.type(TEXTAREA, "Kiparis");
        page.type(PASSWORD, "Password");

        // Проверяем значения
        Assert.assertEquals(page.getValue(TEXT_INPUT), "Сазонов Владимир Владимирович");
        Assert.assertEquals(page.getValue(TEXTAREA), "Kiparis");
        Assert.assertEquals(page.getValue(PASSWORD), "Password");

        // 3. Работаем с выпадающими списками
        page.selectByVisibleText(DROPDOWN, "Two");
        page.selectFromDatalist(DATALIST_INPUT, "Seattle");

        // 4. Чекбоксы
        page.setCheckbox(CHECKBOX_1, true);
        page.setCheckbox(CHECKBOX_2, true);
        Assert.assertTrue(page.isElementSelected(CHECKBOX_1), "Checkbox 1 не выбран");
        Assert.assertTrue(page.isElementSelected(CHECKBOX_2), "Checkbox 2 не выбран");

        // 5. Радиобаттон
        page.setRadio(RADIO_2);
        Assert.assertTrue(page.isElementSelected(RADIO_2), "Радиобаттон не выбран");

        // 6. Дополнительные задания
        page.setDate(DATE_PICKER, LocalDate.of(2024, 9, 23));
        page.setColor(COLOR_PICKER, "#198754");
        page.setRangeToMax(RANGE);

        // 7. Отправка формы
        page.click(SUBMIT_BUTTON);

        // 8. Проверка сообщения
        Assert.assertEquals(page.getText(MESSAGE), "Received!");
    }
}