package page;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$x;

public class TaskOneSoftAssertionsPage {

    private final ElementsCollection exampleTitles = $$x("//div[@class = 'markdown-heading']//h4"); //для поиска по заголовку названия примера
    private final ElementsCollection examplesCode = $$x("//span[@class = 'pl-c1']"); //для поиска по аннотации JUnit5

    /**
     * Метод получения заголовка из последнего примера использования Selenide
     * @return возвращает текст заголовка последнего элемента коллекции
     */
    @Step("Получить заголовок последнего примера")
    public String getLastTitleExample() {
        return exampleTitles.last().getText();
    }

    /**
     * Метод, утверждающий, что на странице есть аннотация, характерная для JUnit5
     * @return возвращает true если есть характерная аннотация
     */
    @Step("В примере есть характерная для JUnit5 аннотация")
    public boolean isAnnotationJUnit5 (String annotationJUnit5) {
        return examplesCode.stream()
                .anyMatch(n -> n.getText().equals(annotationJUnit5));
    }
}
