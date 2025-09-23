package page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

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
    private final SelenideElement fieldYearOfBirth= $x("//select[@class='react-datepicker__year-select']"); //поле Year Of Birth
    private final SelenideElement fieldMonthOfBirth= $x("//select[@class='react-datepicker__month-select']"); //поле Month Of Birth
    private final SelenideElement fieldSubjects= $x("//input[@id='subjectsInput']"); //поле Subjects

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
        //клик на нужном исходя из пола
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

}
