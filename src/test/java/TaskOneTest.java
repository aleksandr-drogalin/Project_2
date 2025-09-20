import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.TaskOneMainPage;
import page.TaskOneSoftAssertionsPage;
import page.TaskOneWikiPage;

/**
 * Задание №1.
 * Необходимо открыть страницу Selenide в Github
 * Перейти в раздел Wiki проекта
 * Убедиться что в списке страниц есть страница Soft assertions
 * Открыть страницу SoftAssertions и проверить, что внутри есть пример кода для JUnit5
 */
public class TaskOneTest extends BaseTest{

    private static final String BASE_URL = "https://github.com/selenide/selenide";
    private static final String EXPECTED_TITLE = "3. Using JUnit5 extend test class:";
    private static final String CHECKED_ANNOTATION = "ExtendWith";


    @Test
    @DisplayName("Тест проверяет, что внутри страницы Soft assertions есть пример кода для JUnit5")
    public void checkExampleCode() {
       TaskOneWikiPage taskOneWikiPage = new TaskOneMainPage(BASE_URL).clickOnButtonWiki();
       taskOneWikiPage.clickOnButtonMorePages();
       TaskOneSoftAssertionsPage taskOneSoftAssertionsPage = taskOneWikiPage.clickOnButtonSoftAssertions();
       String actualResult = taskOneSoftAssertionsPage.getLastTitleExample();
       Assertions.assertEquals(EXPECTED_TITLE, actualResult);
       Assertions.assertTrue(taskOneSoftAssertionsPage.isAnnotationJUnit5(CHECKED_ANNOTATION));
    }
}