package ui.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.Color;
import java.io.File;
import static com.codeborne.selenide.Selenide.$x;

public class DemoQAPracticeFormPage {

    String baseURL = BaseURLProvider.properties.getProperty("demoQA");

    public void open() {
        Selenide.open(baseURL);
    }

    private final SelenideElement inputFirstName = $x("//input[@id='firstName']");
    private final SelenideElement inputLastName = $x("//input[@id='lastName']");
    private final SelenideElement inputEmail = $x("//input[@id='userEmail']");
    private final SelenideElement inputMobile = $x("//input[@id = 'userNumber']");
    private final SelenideElement inputDateOfBirth = $x("//input[@id='dateOfBirthInput']");
    private final SelenideElement inputDay15 = $x("//div[text()='15']");
    private final SelenideElement inputYearOfBirth = $x("//option[@value='1900']/parent::select");
    private final SelenideElement inputYear1994 = $x("//option[@value='1994']");
    private final SelenideElement inputMonthOfBirth = $x("//option[@value='0']/parent::select");
    private final SelenideElement inputMonthMay = $x("//option[text()='May']");
    private final SelenideElement inputSubjects = $x("//input[@id='subjectsInput']");
    private final SelenideElement buttonUploadPicture = $x("//input[@id='uploadPicture']");
    private final SelenideElement inputCurrentAddress = $x("//textarea[@id='currentAddress']");
    private final SelenideElement inputState = $x("//div[@id='state']");
    private final SelenideElement inputCity = $x("//div[@id='city']");
    private final SelenideElement buttonSubmit = $x("//button[@id='submit']");
    private final SelenideElement titleThanksSubmittingForm = $x("//div[text()='Thanks for submitting the form']");
    private final SelenideElement checkBoxHobbiesSport = $x("//input[@id='hobbies-checkbox-1']/parent::div");
    private final SelenideElement checkBoxHobbiesReading = $x("//input[@id='hobbies-checkbox-2']/parent::div");
    private final SelenideElement checkBoxHobbiesMusic = $x("//input[@id='hobbies-checkbox-3']/parent::div");


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
        switch (Gender.MALE.val()) {
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
                throw new IllegalArgumentException("Пол должен быть либо Male, либо Female, либо Other");
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
    public DemoQAPracticeFormPage setDateOfBirth15May1994() {
        inputDateOfBirth.click();
        inputYearOfBirth.click();
        inputYear1994.click();
        inputMonthOfBirth.click();
        inputMonthMay.click();
        inputDay15.click();
        return this;
    }

    @Step("Заполнение поля Subjects")
    public DemoQAPracticeFormPage setInputSubjects(String subjects) {
        inputSubjects.setValue(subjects).pressEnter();
        return this;
    }

    @Step("Заполнение чек-боксов")
    public DemoQAPracticeFormPage setCheckBoxHobbies () {
        checkBoxHobbiesSport.click();
        checkBoxHobbiesReading.click();
        checkBoxHobbiesMusic.click();
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
    public boolean errorBorderColorInputEmail(String expectedColor) {
        String actualRgbColor = inputEmail.getCssValue("border-color");
        String expectedRgbColor = Color.fromString(expectedColor).asRgb();
        return actualRgbColor.equals(expectedRgbColor);
    }

    @Step("Проверка появления иконки внутри поля при ошибке валидации")
    public boolean errorLogoInFieldEmail(String expectedURL) {
        String actualURL = inputEmail.getCssValue("background-image");
        return expectedURL.equals(actualURL);
    }
}
