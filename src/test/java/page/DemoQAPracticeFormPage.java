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
    //private final SelenideElement radioGender = $x("//input[@id='gender-radio-1']"); //поле Email


    @Step ("Заполнение поля firstName")
    public void setFieldFirstName(String firstName) {
        fieldFirstName.setValue(firstName);
    }

    @Step ("Заполнение поля lastName")
    public void setFieldLastName(String lastName) {
        fieldLastName.setValue(lastName);
    }

    @Step ("Заполнение поля Email")
    public void setFieldEmail(String email) {
        fieldEmail.setValue(email);
    }

    @Step ("Выбор радиокнопки Gender")
    public void setRadioGender(String gender) {
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
                throw new IllegalArgumentException("Пол должен быть либо Male, либо Female, в крайнем случае Other, хотя это не нормально)))");
        }
        //клик на нужном исходя из пола
        $x("//input[@id='gender-radio-" + genderNumber +"']/parent::div").click();
    }




}
