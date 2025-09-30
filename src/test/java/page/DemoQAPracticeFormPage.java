package page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.Color;
import java.io.File;
import static com.codeborne.selenide.Selenide.$x;

public class DemoQAPracticeFormPage {

//    public DemoQAPracticeFormPage(String baseUrl) {
//        Selenide.open(baseUrl);
//    }
    public void open(String url) {
        Selenide.open(url);
    }

    private final SelenideElement inputFirstName = $x("//input[@id='firstName']");
    private final SelenideElement inputLastName = $x("//input[@id='lastName']");
    private final SelenideElement inputEmail = $x("//input[@id='userEmail']");
    private final SelenideElement inputMobile = $x("//input[@id = 'userNumber']");
    private final SelenideElement inputDateOfBirth = $x("//input[@id='dateOfBirthInput']");
    private final SelenideElement inputYearOfBirth = $x("//option[@value='1900']/parent::select");
    private final SelenideElement inputMonthOfBirth = $x("//option[@value='0']/parent::select");
    private final SelenideElement inputSubjects = $x("//input[@id='subjectsInput']");
    private final SelenideElement buttonUploadPicture = $x("//input[@id='uploadPicture']");
    private final SelenideElement inputCurrentAddress = $x("//textarea[@id='currentAddress']");
    private final SelenideElement inputState = $x("//div[@id='state']");
    private final SelenideElement inputCity = $x("//div[@id='city']");
    private final SelenideElement buttonSubmit = $x("//button[@id='submit']");
    private final SelenideElement titleThanksSubmittingForm = $x("//div[text()='Thanks for submitting the form']");

    @Step("Заполнение поля firstName")
    public DemoQAPracticeFormPage setInputFirstName(String firstName) {
        inputFirstName.setValue(firstName);
        return this;
    }

    @Step("Заполнение поля lastName")
    public DemoQAPracticeFormPage setInputLastName(String lastName) {
        inputLastName.setValue(lastName);
        return this;
    }

    @Step("Заполнение поля Email")
    public DemoQAPracticeFormPage setInputEmail(String email) {
        inputEmail.setValue(email);
        return this;
    }

    @Step("Выбор радиокнопки Gender")
    public DemoQAPracticeFormPage setRadioGender(String gender) {
        int genderNumber;
        switch (gender) {
            case "Male" :
                genderNumber = 1;
                break;
            case "Female" :
                genderNumber = 2;
                break;
            case "Other" :
                genderNumber = 3;
                break;
            default:
                throw new IllegalArgumentException("Пол должен быть либо Male, либо Female, в крайнем случае Other, хотя это не нормально!");
        }
        //клик на нужном
        $x("//input[@id='gender-radio-" + genderNumber +"']/parent::div").click();
        return this;
    }

    @Step("Заполнение поля Mobile")
    public DemoQAPracticeFormPage setInputMobile(String mobile) {
        inputMobile.setValue(mobile);
        return this;
    }

    @Step("Заполнение поля Date Of Birth")
    public DemoQAPracticeFormPage setFieldDateOfBirth(int year, String month, int day) {
        inputDateOfBirth.click();
        inputYearOfBirth.click();
        $x("//option[@value='" + year +"']").click(); //выбор года рождения
        inputMonthOfBirth.click();
        $x("//option[text()='" + month +"']").click(); //выбор месяца рождения
        $x("//div[text()='" + day +"']").click(); //выбор числа месяца
        return this;
    }

    @Step("Заполнение поля Subjects")
    public DemoQAPracticeFormPage setInputSubjects(String subjects) {
        inputSubjects.setValue(subjects).pressEnter();
        return this;
    }

    @Step("Заполнение чекбокса Hobbies")
    public DemoQAPracticeFormPage setCheckBoxHobbies (String[] hobbies) {
        for (int i = 1; i <= hobbies.length ; i++) {
            if(hobbies[i-1] != null) {
                $x("//input[@id='hobbies-checkbox-" + i + "']/parent::div").click();
            }
        }
        return this;
    }

    @Step("Загрузка изображения")
    public DemoQAPracticeFormPage uploadPicture(String pathToPicture) {
        buttonUploadPicture.scrollTo().uploadFile(new File(pathToPicture));
        return this;
    }

    @Step("Заполнение поля Current Address")
    public DemoQAPracticeFormPage setCurrentAddress(String currentAddress) {
        inputCurrentAddress.setValue(currentAddress);
        return this;
    }

    @Step("Заполнение поля Select State")
    public DemoQAPracticeFormPage setInputState(int numberState) {
        inputState.click();
        $x("//div[@id='react-select-3-option-" + numberState +"']").click();
        return this;
    }

    @Step("Заполнение поля Select City")
    public DemoQAPracticeFormPage setInputCity(int numberCity) {
        inputCity.click();
        $x("//div[@id='react-select-4-option-" + numberCity + "']");
        return this;
    }

    @Step("Клик на кнопку Submit")
    public void clickOnButtonSubmit() {
        buttonSubmit.scrollTo().click();
    }

    @Step("Проверка появления уведомления об успешном заполнении формы")
    public boolean isTitleSubmittingForm() {
        return titleThanksSubmittingForm.isDisplayed();
    }

    @Step("Проверка цвета рамки поля при ошибке валидации")
    public boolean errorBorderColor(String fieldName, String expectedColor) {
        // Получаем цвет в формате rgb
        String actualColor;
        switch (fieldName){
            case "Email" :
                actualColor = inputEmail.getCssValue("border-color");
            break;
            default: throw new IllegalArgumentException("Недопустимое название поля");
        }

        // Конвертируем ожидаемый цвет в формат rgba, если он в формате #hex
        String expectedRgbColor = Color.fromString(expectedColor).asRgb();

        // Сравниваем цвета
        return actualColor.equals(expectedRgbColor);
    }

    //
    @Step("Проверка появления иконки внутри поля при ошибке валидации")
    public boolean errorLogoInField(String fieldName, String expectedURL) {
        String actualURL;
        switch (fieldName) {
            case "Email" : actualURL = inputEmail.getCssValue("background-image");
            break;
            default: throw new IllegalArgumentException("Недопустимое название поля");
        }
        return expectedURL.equals(actualURL);
    }
}
