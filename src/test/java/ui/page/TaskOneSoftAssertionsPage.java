package ui.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class TaskOneSoftAssertionsPage {

    private final SelenideElement titleExampleJUnit = $x("//h4[text()='3. Using JUnit5 extend test class:']");
    private final SelenideElement exampleCodeJUnit = $x("//span[text()='ExtendWith']");


    @Step("Отображается заголовок примера для JUnit5")
    public boolean titleExampleJUnitIsDisplayed() {
        return titleExampleJUnit.scrollTo().isDisplayed();
    }

    @Step("Отображается характерная аннотация для JUnit5")
    public boolean exampleCodeJUnit5IsDisplayed() {
        return exampleCodeJUnit.scrollTo().isDisplayed();
    }
}
