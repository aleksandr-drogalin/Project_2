import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.TaskTwoMainPage;

/**
 * Задание №2
 * Откройте https://the-internet.herokuapp.com/drag_and_drop
 * Перенесите прямоугольник А на место В
 * Проверьте, что прямоугольники действительно поменялись
 * В Selenide есть команда $(element).dragAndDrop($(to-element)), проверьте, работает ли тест, если использовать её вместо actions()
 */

public class TaskTwoTest extends BaseTest {

    private static final String BASE_URL = "https://the-internet.herokuapp.com/drag_and_drop";
    private static final String EXPECTED_TEXT_FIRST_SQUARE = "B";
    private static final String EXPECTED_TEXT_SECOND_SQUARE = "A";

    /**
     * Тест проверяет, что при переносе квадрата А в квадрат В, меняется СОДЕРЖИМОЕ исходных
     * квадратов, выглядит будто меняются местами, по факту меняется только содержимое (текст)
     * $(element).dragAndDrop($(to-element)) тоже работает
     */
    @Test
    @DisplayName("Тест проверяет, что квадрат А меняется местами с квадратом В")
    public void changeTwoSquare() {
        TaskTwoMainPage taskTwoMainPage = new TaskTwoMainPage(BASE_URL);
        taskTwoMainPage.changeSquare();
        Assertions.assertEquals(EXPECTED_TEXT_FIRST_SQUARE, taskTwoMainPage.getTextFirstSquare());
        Assertions.assertEquals(EXPECTED_TEXT_SECOND_SQUARE, taskTwoMainPage.getTextSecondSquare());
    }
}
