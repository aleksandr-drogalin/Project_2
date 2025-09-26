package page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.Color;
import java.io.File;
import static com.codeborne.selenide.Selenide.$x;

public class DemoQAPracticeFormPage {
    //конструктор класса
    public DemoQAPracticeFormPage(String baseUrl) {
        Selenide.open(baseUrl);
    }

    private final SelenideElement fieldFirstName = $x("//input[@id='firstName']"); //поле firstName
    private final SelenideElement fieldLastName = $x("//input[@id='lastName']"); //поле lastName
    private final SelenideElement fieldEmail = $x("//input[@id='userEmail']"); //поле Email
    private final SelenideElement fieldMobile = $x("//input[@id = 'userNumber']"); //поле Mobile
    private final SelenideElement fieldDateOfBirth = $x("//input[@id='dateOfBirthInput']"); //поле Date Of Birth
    private final SelenideElement fieldYearOfBirth = $x("//select[@class='react-datepicker__year-select']"); //поле Year Of Birth
    private final SelenideElement fieldMonthOfBirth = $x("//select[@class='react-datepicker__month-select']"); //поле Month Of Birth
    private final SelenideElement fieldSubjects = $x("//input[@id='subjectsInput']"); //поле Subjects
    private final SelenideElement buttonUploadPicture = $x("//input[@id='uploadPicture']"); //кнопка uploadPicture
    private final SelenideElement fieldCurrentAddress = $x("//textarea[@id='currentAddress']"); //поле Current Address
    private final SelenideElement fieldSelectState = $x("//div[@id='state']"); //поле Select State
    private final SelenideElement fieldSelectCity = $x("//div[@id='city']"); //поле Select City
    private final SelenideElement buttonSubmit = $x("//button[@id='submit']"); //кнопка Submit
    private final SelenideElement titleThanksSubmittingForm = $x("//div[@id='example-modal-sizes-title-lg']"); //Заголовок успешно заполненной формы

    @Step ("Заполнение поля firstName")
    public DemoQAPracticeFormPage setFieldFirstName(String firstName) {
        fieldFirstName.setValue(firstName);
        return this;
    }

    @Step ("Заполнение поля lastName")
    public DemoQAPracticeFormPage setFieldLastName(String lastName) {
        fieldLastName.setValue(lastName);
        return this;
    }

    @Step ("Заполнение поля Email")
    public DemoQAPracticeFormPage setFieldEmail(String email) {
        fieldEmail.setValue(email);
        return this;
    }

    @Step ("Выбор радиокнопки Gender")
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

    @Step ("Заполнение поля Mobile")
    public DemoQAPracticeFormPage setFieldMobile(String mobile) {
        fieldMobile.setValue(mobile);
        return this;
    }

    @Step ("Заполнение поля Date Of Birth")
    public DemoQAPracticeFormPage setFieldDateOfBirth(int year, String month, int day) {
        fieldDateOfBirth.click();
        fieldYearOfBirth.click();
        $x("//option[@value='" + year +"']").click(); //выбор года рождения
        fieldMonthOfBirth.click();
        $x("//option[text()='" + month +"']").click(); //выбор месяца рождения
        $x("//div[text()='" + day +"']").click(); //выбор числа месяца
        return this;
    }

    @Step ("Заполнение поля Subjects")
    public DemoQAPracticeFormPage setFieldSubjects(String subjects) {
        fieldSubjects.setValue(subjects).pressEnter();
        return this;
    }

    @Step ("Заполнение чекбокса Hobbies")
    public DemoQAPracticeFormPage setCheckBoxHobbies (String[] hobbies) {
        for (int i = 1; i <= hobbies.length ; i++) {
            if(hobbies[i-1] != null) {
                $x("//input[@id='hobbies-checkbox-" + i + "']/parent::div").click();
            }
        }
        return this;
    }

    @Step ("Загрузка изображения")
    public DemoQAPracticeFormPage uploadPicture(String pathToPicture) {
        buttonUploadPicture.scrollTo().uploadFile(new File(pathToPicture));
        return this;
    }

    @Step ("Заполнение поля Current Address")
    public DemoQAPracticeFormPage setCurrentAddress(String currentAddress) {
        fieldCurrentAddress.setValue(currentAddress);
        return this;
    }

    @Step ("Заполнение поля Select State")
    public DemoQAPracticeFormPage setFieldSelectState(int numberState) {
        fieldSelectState.click();
        $x("//div[@id='react-select-3-option-" + numberState +"']").click();
        return this;
    }

    @Step ("Заполнение поля Select City")
    public DemoQAPracticeFormPage setFieldSelectCity(int numberCity) {
        fieldSelectCity.click();
        $x("//div[@id='react-select-4-option-" + numberCity + "']");
        return this;
    }

    @Step ("Клик на кнопку Submit")
    public DemoQAPracticeFormPage clickOnButtonSubmit() {
        buttonSubmit.scrollTo().click();
        return this;
    }

    @Step ("Проверка появления уведомления об успешном заполнении формы")
    public boolean isTitleSubmittingForm() {
        return titleThanksSubmittingForm.isDisplayed();
    }

    @Step ("Проверка цвета рамки поля при ошибке валидации")
    public boolean errorBorderColor(String fieldName, String expectedColor) {
        // Получаем цвет в формате rgb
        String actualColor;
        switch (fieldName){
            case "Email" :
                actualColor = fieldEmail.getCssValue("border-color");
            break;
            default: throw new IllegalArgumentException("Недопустимое название поля");
        }

        // Конвертируем ожидаемый цвет в формат rgba, если он в формате #hex
        String expectedRgbColor = Color.fromString(expectedColor).asRgb();

        // Сравниваем цвета
        return actualColor.equals(expectedRgbColor);
    }

    //
    @Step ("Проверка появления иконки внутри поля при ошибке валидации")
    public boolean errorLogoInField(String fieldName, String expectedURL) {
        String actualURL;
        switch (fieldName) {
            case "Email" : actualURL = fieldEmail.getCssValue("background-image");
            break;
            default: throw new IllegalArgumentException("Недопустимое название поля");
        }
        return expectedURL.equals(actualURL);
    }
}
