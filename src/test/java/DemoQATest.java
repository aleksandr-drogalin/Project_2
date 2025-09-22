import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.PageLoadStrategy;
import page.DemoQAPracticeFormPage;

import java.util.stream.Stream;

import static com.codeborne.selenide.Configuration.pageLoadStrategy;

public class DemoQATest extends BaseTest{

    private static final String BASE_URL = "https://demoqa.com/automation-practice-form";
    //абсолютный путь к директории проекта
    private static final String ABSOLUTE_PATH_TO_PROJECT = System.getProperty("user.dir");

    //валидные тестовые данные для полей
    private static final String FIRST_NAME = "Иван";
    private static final String LAST_NAME = "Иванов";
    private static final String EMAIL = "ivanov@gmail.com";
    private static final String GENDER = "Male"; //еще валидно Female и Other


    //параметризация через метод
    private static Stream<Arguments> testData() {
        return Stream.of(
                //валидные тестовые данные
                Arguments.arguments(FIRST_NAME, LAST_NAME, EMAIL, GENDER)
        );
    }

    //тестовый метод
    @ParameterizedTest
    @DisplayName("Заполнение формы Practice Form")
    @MethodSource("testData")
    public void setPracticeForm(String firstName, String lastName, String email, String gender) {
        pageLoadStrategy = PageLoadStrategy.EAGER.toString(); // стратегия загрузки страницы
        DemoQAPracticeFormPage demoQAPracticeFormPage = new DemoQAPracticeFormPage(BASE_URL);
        demoQAPracticeFormPage.setFieldFirstName(firstName);
        demoQAPracticeFormPage.setFieldLastName(lastName);
        demoQAPracticeFormPage.setFieldEmail(email);
        demoQAPracticeFormPage.setRadioGender(gender);

    }


}
