import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.PageLoadStrategy;
import page.MonthOfBirth;

import java.util.stream.Stream;

import static com.codeborne.selenide.Configuration.pageLoadStrategy;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static page.PageRepository.demoQAPracticeFormPage;

public class DemoQATest extends BaseTest {

    //валидные тестовые данные для полей
    private static final String FIRST_NAME = "Иван";
    private static final String LAST_NAME = "Иванов";
    private static final String EMAIL = "ivanov@gmail.com";
    private static final String GENDER = "Male"; //еще валидно Female и Other
    private static final String MOBILE = "9105552323";
    private static final int YEAR_OF_BIRTH = 1995;
    private static final String MONTH_OF_BIRTH = MonthOfBirth.JANUARY.getName();
    private static final int DAY_OF_BIRTH = 19;
    private static final String SUBJECTS = "English";
    private static final String[] HOBBIES = {"Sports", null , null}; //Еще валидно "Reading"  "Music"
    private static final String PATH_TO_PICTURE = "src/test/resources/JPG-test-image.jpg";
    private static final String CURRENT_ADDRESS = "University street";
    private static final int NUMBER_STATE = 1;
    private static final int NUMBER_CITY = 1;

    private static final String BORDER_COLOR_ERROR_FIELD_EMAIL = "#dc3545";
    private static final String URL_LOGO_ERROR_FIELD = "url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' width='12' height='12' fill='none' stroke='%23dc3545' viewBox='0 0 12 12'%3e%3ccircle cx='6' cy='6' r='4.5'/%3e%3cpath stroke-linejoin='round' d='M5.8 3.6h.4L6 6.5z'/%3e%3ccircle cx='6' cy='8.2' r='.6' fill='%23dc3545' stroke='none'/%3e%3c/svg%3e\")";

    //Валидные тестовые данные для поля Email, параметризация через метод
    private static Stream<Arguments> validTestData() {
        return Stream.of(
               Arguments.arguments(FIRST_NAME, LAST_NAME, EMAIL, GENDER, MOBILE, YEAR_OF_BIRTH, MONTH_OF_BIRTH, DAY_OF_BIRTH, SUBJECTS, HOBBIES, PATH_TO_PICTURE, CURRENT_ADDRESS, NUMBER_STATE, NUMBER_CITY),
               Arguments.arguments(FIRST_NAME, LAST_NAME, "ivanov1995@gmail.com", GENDER, MOBILE, YEAR_OF_BIRTH, MONTH_OF_BIRTH, DAY_OF_BIRTH, SUBJECTS, HOBBIES, PATH_TO_PICTURE, CURRENT_ADDRESS, NUMBER_STATE, NUMBER_CITY)
        );
    }

    //Невалидные тестовые данные для поля Email, параметризация через метод
    private static Stream<Arguments> invalidTestData() {
        return Stream.of(
                Arguments.arguments(FIRST_NAME, LAST_NAME, "ivanov1995gmail.com", GENDER, MOBILE, YEAR_OF_BIRTH, MONTH_OF_BIRTH, DAY_OF_BIRTH, SUBJECTS, HOBBIES, PATH_TO_PICTURE, CURRENT_ADDRESS, NUMBER_STATE, NUMBER_CITY),
                Arguments.arguments(FIRST_NAME, LAST_NAME, "ivanov1995@gmail", GENDER, MOBILE, YEAR_OF_BIRTH, MONTH_OF_BIRTH, DAY_OF_BIRTH, SUBJECTS, HOBBIES, PATH_TO_PICTURE, CURRENT_ADDRESS, NUMBER_STATE, NUMBER_CITY)
        );
    }

    //тестовый метод для позитивных сценариев
    @ParameterizedTest
    @DisplayName("Успешное заполнение поля Email формы Practice Form")
    @MethodSource("validTestData")
    public void setPracticeForm(String firstName, String lastName, String email, String gender, String mobile, int yearOfBirth, String monthOfBirth, int dayOfBirth, String subjects, String[] hobbies, String pathToPicture, String currentAddress, int numberState, int numberCity) {
        pageLoadStrategy = PageLoadStrategy.EAGER.toString();

        demoQAPracticeFormPage.open(properties.getProperty("demoQA"));
        demoQAPracticeFormPage
                .setInputFirstName(firstName)
                .setInputLastName(lastName)
                .setInputEmail(email)
                .setRadioGender(gender)
                .setInputMobile(mobile)
                .setFieldDateOfBirth(yearOfBirth, monthOfBirth, dayOfBirth)
                .setInputSubjects(subjects)
                .setCheckBoxHobbies(hobbies)
                .uploadPicture(pathToPicture)
                .setCurrentAddress(currentAddress)
                .setInputState(numberState)
                .setInputCity(numberCity)
                .clickOnButtonSubmit();

        boolean actualResultIsTitleSubmittingForm = demoQAPracticeFormPage.isTitleSubmittingForm();

        assertThat(actualResultIsTitleSubmittingForm).isTrue();
    }

    //тестовый метод проверки ошибки валидации поля Email
    @ParameterizedTest
    @DisplayName("Ошибка заполнения поля Email формы Practice Form")
    @MethodSource("invalidTestData")
    public void checkErrorEmail(String firstName, String lastName, String email, String gender, String mobile, int yearOfBirth, String monthOfBirth, int dayOfBirth, String subjects, String[] hobbies, String pathToPicture, String currentAddress, int numberState, int numberCity) {
        pageLoadStrategy = PageLoadStrategy.EAGER.toString();

        demoQAPracticeFormPage.open(properties.getProperty("demoQA"));
        demoQAPracticeFormPage
                .setInputFirstName(firstName)
                .setInputLastName(lastName)
                .setInputEmail(email)
                .setRadioGender(gender)
                .setInputMobile(mobile)
                .setFieldDateOfBirth(yearOfBirth, monthOfBirth, dayOfBirth)
                .setInputSubjects(subjects)
                .setCheckBoxHobbies(hobbies)
                .uploadPicture(pathToPicture)
                .setCurrentAddress(currentAddress)
                .setInputState(numberState)
                .setInputCity(numberCity)
                .clickOnButtonSubmit();

        boolean actualResultIsTitleSubmittingForm = demoQAPracticeFormPage.isTitleSubmittingForm();
        boolean actualResultIsErrorBorderColor = demoQAPracticeFormPage.errorBorderColor("Email", BORDER_COLOR_ERROR_FIELD_EMAIL);
        boolean actualResultIsErrorLogoInField = demoQAPracticeFormPage.errorLogoInField("Email", URL_LOGO_ERROR_FIELD);

        assertAll(
                () -> assertThat(actualResultIsTitleSubmittingForm).isFalse(),
                () -> assertThat(actualResultIsErrorBorderColor).isTrue(),
                () -> assertThat(actualResultIsErrorLogoInField).isTrue()
        );
    }
}
