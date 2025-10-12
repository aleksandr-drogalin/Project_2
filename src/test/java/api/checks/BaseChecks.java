package api.checks;

import io.qameta.allure.Step;
import io.restassured.response.Response;

public class BaseChecks {

    @Step("Проверка, что код ответа {expectedCode}")
    public static void checkResponseCode(Response response, int expectedCode) {
        response.then().statusCode(expectedCode);
    }


}
