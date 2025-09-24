import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.PageLoadStrategy;
import page.DemoQAPracticeFormPage;

import java.util.stream.Stream;

import static com.codeborne.selenide.Configuration.pageLoadStrategy;

public class DemoQATest extends BaseTest {

    private static final String BASE_URL = "https://demoqa.com/automation-practice-form";
    //абсолютный путь к директории проекта
    private static final String ABSOLUTE_PATH_TO_PROJECT = System.getProperty("user.dir");

    //ОР для позитивных (true) и негативных (false) проверок
    private static final boolean EXPECTED_RESULT = true;
    //валидные тестовые данные для полей
    private static final String FIRST_NAME = "Иван";
    private static final String LAST_NAME = "Иванов";
    private static final String EMAIL = "ivanov@gmail.com";
    private static final String GENDER = "Male"; //еще валидно Female и Other
    private static final String MOBILE = "9105552323";
    private static final int YEAR_OF_BIRTH = 1995;
    private static final String MONTH_OF_BIRTH = "August";
    private static final int DAY_OF_BIRTH = 19;
    private static final String SUBJECTS = "English";
    private static final String[] HOBBIES = {"Sports", "Reading" , "Music"};
    private static final String PATH_TO_PICTURE = "src/test/resources/JPG-test-image.jpg";
    private static final String CURRENT_ADDRESS = "University street";
    private static final int NUMBER_STATE = 1;
    private static final int NUMBER_CITY = 1;

    //параметризация через метод
    private static Stream<Arguments> testData() {
        return Stream.of(
                //валидные тестовые данные
                Arguments.arguments(EXPECTED_RESULT,FIRST_NAME, LAST_NAME, EMAIL, GENDER, MOBILE, YEAR_OF_BIRTH, MONTH_OF_BIRTH, DAY_OF_BIRTH, SUBJECTS, HOBBIES, PATH_TO_PICTURE, CURRENT_ADDRESS, NUMBER_STATE, NUMBER_CITY)
        );
    }

    //тестовый метод
    @ParameterizedTest
    @DisplayName("Заполнение формы Practice Form")
    @MethodSource("testData")
    public void setPracticeForm(boolean expectedResult, String firstName, String lastName, String email, String gender, String mobile, int yearOfBirth, String monthOfBirth, int dayOfBirth, String subjects, String[] hobbies, String pathToPicture, String currentAddress, int numberState, int numberCity) {
        pageLoadStrategy = PageLoadStrategy.EAGER.toString(); // стратегия загрузки страницы
        DemoQAPracticeFormPage demoQAPracticeFormPage = new DemoQAPracticeFormPage(BASE_URL);
        Assertions.assertEquals(EXPECTED_RESULT, demoQAPracticeFormPage
                .setFieldFirstName(firstName)
                .setFieldLastName(lastName)
                .setFieldEmail(email)
                .setRadioGender(gender)
                .setFieldMobile(mobile)
                .setFieldDateOfBirth(yearOfBirth, monthOfBirth, dayOfBirth)
                .setFieldSubjects(subjects)
                .setCheckBoxHobbies(hobbies)
                .uploadPicture(pathToPicture)
                .setCurrentAddress(currentAddress)
                .setFieldSelectState(numberState)
                .setFieldSelectCity(numberCity)
                .clickOnButtonSubmit()
                .isTitleSubmittingForm());
    }


    @Test
    @DisplayName("Отправка пустой формы")
    public void emptyForm() {
        pageLoadStrategy = PageLoadStrategy.EAGER.toString();
        Assertions.assertFalse(new DemoQAPracticeFormPage(BASE_URL).clickOnButtonSubmit().isTitleSubmittingForm());
    }
}
