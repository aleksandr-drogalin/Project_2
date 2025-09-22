package page;

import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;

public class TaskTwoMainPage {

    public TaskTwoMainPage(String baseUrl) {
        Selenide.open(baseUrl);
    }

    private final SelenideElement source = $x("//div[@id='column-a']"); //улучшить локатор
    private final SelenideElement target = $x("//div[@id='column-b']");


    /**
     * Метод переносит квадрат А в цель: квадрат В
     */
    @Step ("Перенос Квадрата А в квадрат В")
    public void changeSquare() {
        actions().dragAndDrop(source, target).build().perform();
//        source.dragAndDrop(DragAndDropOptions.to(target)); //тоже работает
    }


    /**
     * Получаем текст первого квадрата слева (source)
     * @return текст первого квадрата
     */
    @Step ("Получить текст первого квадрата")
    public String getTextFirstSquare() {
        return source.getText();
    }

    /**
     * Получаем текст второго квадрата слева (target)
     * @return текст второго квадрата
     */
    @Step ("Получить текст второго квадрата")
    public String getTextSecondSquare() {
        return target.getText();
    }

}
