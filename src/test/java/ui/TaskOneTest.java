package ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.page.TaskOneSoftAssertionsPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.junit.jupiter.api.Assertions.assertAll;
import static ui.page.PageRepository.taskOneMainPage;

/**
 * Задание №1.
 * Необходимо открыть страницу Selenide в Github
 * Перейти в раздел Wiki проекта
 * Убедиться что в списке страниц есть страница Soft assertions
 * Открыть страницу SoftAssertions и проверить, что внутри есть пример кода для JUnit5
 */
public class TaskOneTest extends BaseTest{

    /**
     * Тест проверяет, что на странице SoftAssertions есть заголовок примера кода для JUnit5
     * а также проверяет наличие кода по характерной для JUnit5 аннотации
     */
    @Test
    @DisplayName("Тест проверяет, что внутри страницы Soft assertions есть пример кода для JUnit5")
    public void checkExampleCode() {
        TaskOneSoftAssertionsPage taskOneSoftAssertionsPage = taskOneMainPage.open().clickOnButtonWiki()
                .clickOnButtonMorePages()
                .clickOnButtonSoftAssertions();

        assertAll(
                () -> assertThat(taskOneSoftAssertionsPage.titleExampleJUnitIsDisplayed()).isTrue(),
                () -> assertThat(taskOneSoftAssertionsPage.exampleCodeJUnit5IsDisplayed()).isTrue()
        );
    }
}