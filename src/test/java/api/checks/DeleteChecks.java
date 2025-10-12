package api.checks;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

public class DeleteChecks {

    @Step("Проверка, что в теле ответа содержится статус-код {expectedCode}")
    public static void checkInsideBodyStatusCode(Response response, int expectedCode) {
        response.then().assertThat().body("code", equalTo(expectedCode));
    }

    @Step("Проверка, что в теле ответа содержится поле тип {expectedType}")
    public static void checkType(Response response, String expectedType) {
        response.then().body("type", equalTo(expectedType));
    }

    @Step("Проверка, что в теле ответа содержится сообщение с id {expectedMessage}")
    public static void checkMessage(Response response, String expectedMessage) {
        response.then().body("message", equalTo(expectedMessage));
    }
}
