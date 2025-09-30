import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.TaskOneSoftAssertionsPage;



import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static page.PageRepository.taskOneMainPage;

/**
 * Задание №1.
 * Необходимо открыть страницу Selenide в Github
 * Перейти в раздел Wiki проекта
 * Убедиться что в списке страниц есть страница Soft assertions
 * Открыть страницу SoftAssertions и проверить, что внутри есть пример кода для JUnit5
 */
public class TaskOneTest extends BaseTest{

    private static final String EXPECTED_TITLE = "3. Using JUnit5 extend test class:";
    private static final String CHECKED_ANNOTATION = "ExtendWith";


    /**
     * Тест проверяет, что на странице SoftAssertions есть заголовок примера кода для JUnit5
     * а также проверяет наличие кода по характерной для JUnit5 аннотации
     */
    @Test
    @DisplayName("Тест проверяет, что внутри страницы Soft assertions есть пример кода для JUnit5")
    public void checkExampleCode() {
        TaskOneSoftAssertionsPage taskOneSoftAssertionsPage = taskOneMainPage.open(properties.getProperty("taskOne")).clickOnButtonWiki()
                .clickOnButtonMorePages()
                .clickOnButtonSoftAssertions();

        String actualTitle = taskOneSoftAssertionsPage.getLastTitleExample();
        boolean actualResultIsAnnotationJUnit5 = taskOneSoftAssertionsPage.isAnnotationJUnit5(CHECKED_ANNOTATION);

        assertThat(actualTitle).isEqualTo(EXPECTED_TITLE);
        assertThat(actualResultIsAnnotationJUnit5).isTrue();
    }
}