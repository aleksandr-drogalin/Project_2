package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Страница раздела Wiki Selenide на GitHub
 */
public class TaskOneWikiPage {

    private final SelenideElement buttonShow4MorePages = $x("//li[@class = 'Box-row wiki-more-pages-link']//button");
    private final SelenideElement buttonSoftAssertions = $x("//a[text()='SoftAssertions']");

    /**
     * В списке Pages раскрываем список нажатием на кнопку Show 4 more pages...
     */
    @Step ("Нажать на кнопку Show 4 more pages")
    public TaskOneWikiPage clickOnButtonMorePages(){
        buttonShow4MorePages.click();
        return this;
    }

    /**
     * Нажимаем на SoftAssertions
     * @return возвращает экземпляр страницы SoftAssertions
     */
    @Step ("Нажать на кнопку SoftAssertions")
    public TaskOneSoftAssertionsPage clickOnButtonSoftAssertions() {
        buttonSoftAssertions.click();
        return new TaskOneSoftAssertionsPage();
    }
}
