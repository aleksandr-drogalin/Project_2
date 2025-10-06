package api.action;

import io.qameta.allure.Step;
import io.restassured.response.Response;

public class BaseAction {

    @Step("Проверка кода ответа")
    public static void checkResponseCode(Response response, int expectedCode) {
        response.then().statusCode(expectedCode);
    }


}
