package page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Главная страница Selenide на GitHub
 */
public class TaskOneMainPage {

    public TaskOneMainPage(String baseURL) {
        Selenide.open(baseURL);
    }

    private final SelenideElement buttonWiki = $x(".//a[@id='wiki-tab']/parent::li"); //кнопка (элемент списка) Wiki

    /**
     * Переход в раздел Wiki
     */
    @Step ("Переход в раздел Wiki")
    public TaskOneWikiPage clickOnButtonWiki(){
        buttonWiki.click();
        return new TaskOneWikiPage();
    }
}
