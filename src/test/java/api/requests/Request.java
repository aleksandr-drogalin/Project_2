package api.requests;

import api.model.NewPet;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Request {

    String baseURI = ApiProvider.properties.getProperty("basePetStore");

    @Step("Запрос на добавление карточки нового питомца")
    public Response addNewPet(NewPet newPet) {
        return given()
                .baseUri(baseURI)
                .header("Content-type", "application/json")
                .body(newPet)
                .post(ApiProvider.properties.getProperty("endCreateNewPet"));
    }

    @Step("Запрос на получение карточки питомца по ID")
    public Response getPet(int petId) {
        return given()
                .baseUri(baseURI)
                .get(ApiProvider.properties.getProperty("getPet")+petId);
    }

    @Step("Запрос на полное обновление карточки питомца")
    public Response updatePet(NewPet newPet) {
        return given()
                .baseUri(baseURI)
                .header("Content-type", "application/json")
                .body(newPet)
                .put(ApiProvider.properties.getProperty("updatePet"));
    }

    @Step("Запрос на удаление карточки питомца")
    public Response deletePet(int petId) {
        return given()
                .baseUri(baseURI)
                .delete(ApiProvider.properties.getProperty("deletePet")+petId);
    }
}
