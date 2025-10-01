package page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;

public class TaskTwoMainPage {

    String baseURL = BaseURLProvider.properties.getProperty("taskTwo");

    public TaskTwoMainPage open() {
        Selenide.open(baseURL);
        return this;
    }

    private final SelenideElement source = $x("//div[@id='column-a']"); //улучшить локатор
    private final SelenideElement target = $x("//div[@id='column-b']");


    /**
     * Метод переносит квадрат А в цель: квадрат В
     */
    @Step("Перенос Квадрата А в квадрат В")
    public TaskTwoMainPage changeSquareAtoB() {
        actions().dragAndDrop(source, target).build().perform();
//        source.dragAndDrop(DragAndDropOptions.to(target)); //тоже работает
        return this;
    }


    /**
     * Получаем текст первого квадрата слева (source)
     * @return текст первого квадрата
     */
    @Step("Получить текст первого квадрата")
    public String getTextFirstSquare() {
        return source.getText();
    }

    /**
     * Получаем текст второго квадрата слева (target)
     * @return текст второго квадрата
     */
    @Step("Получить текст второго квадрата")
    public String getTextSecondSquare() {
        return target.getText();
    }

}
