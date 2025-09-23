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
    private static final String MOBILE = "9105552323";
    private static final int YEAR_OF_BIRTH = 1995;
    private static final String MONTH_OF_BIRTH = "August";
    private static final int DAY_OF_BIRTH = 19;
    private static final String SUBJECTS = "English";
    private static final String[] HOBBIES = {"Sports", "Reading" , "Music"};

//    private static final boolean HOBBIES_SPORTS = true;
//    private static final boolean HOBBIES_READING = false;
//    private static final boolean HOBBIES_MUSIC = true;


    //параметризация через метод
    private static Stream<Arguments> testData() {
        return Stream.of(
                //валидные тестовые данные
                Arguments.arguments(FIRST_NAME, LAST_NAME, EMAIL, GENDER, MOBILE, YEAR_OF_BIRTH, MONTH_OF_BIRTH, DAY_OF_BIRTH, SUBJECTS, HOBBIES)
        );
    }

    //тестовый метод
    @ParameterizedTest
    @DisplayName("Заполнение формы Practice Form")
    @MethodSource("testData")
    public void setPracticeForm(String firstName, String lastName, String email, String gender, String mobile, int yearOfBirth, String monthOfBirth, int dayOfBirth, String subjects, String[] hobbies) {
        pageLoadStrategy = PageLoadStrategy.EAGER.toString(); // стратегия загрузки страницы
        DemoQAPracticeFormPage demoQAPracticeFormPage = new DemoQAPracticeFormPage(BASE_URL);
        demoQAPracticeFormPage
                .setFieldFirstName(firstName)
                .setFieldLastName(lastName)
                .setFieldEmail(email)
                .setRadioGender(gender)
                .setFieldMobile(mobile)
                .setFieldDateOfBirth(yearOfBirth, monthOfBirth, dayOfBirth)
                .setFieldSubjects(subjects)
                .setCheckBoxHobbies(hobbies);

    }
}
