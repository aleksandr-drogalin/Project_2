package api.requests;

import api.model.NewPet;
import api.provider.ApiPropertiesProvider;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Request {

    String baseURI = ApiPropertiesProvider.propertiesApi.getProperty("basePetStore");

    @Step("Запрос на добавление карточки нового питомца")
    public Response addNewPet(NewPet newPet) {
        return given()
                .baseUri(baseURI)
                .header("Content-type", "application/json")
                .body(newPet)
                .post(ApiPropertiesProvider.propertiesApi.getProperty("endCreateNewPet"));
    }

    @Step("Запрос на получение карточки питомца по ID")
    public Response getPet(int petId) {
        return given()
                .baseUri(baseURI)
                .get(ApiPropertiesProvider.propertiesApi.getProperty("getPet") + "/" + petId);
    }

    @Step("Запрос на полное обновление карточки питомца")
    public Response updatePet(NewPet newPet) {
        return given()
                .baseUri(baseURI)
                .header("Content-type", "application/json")
                .body(newPet)
                .put(ApiPropertiesProvider.propertiesApi.getProperty("updatePet"));
    }

    @Step("Запрос на удаление карточки питомца")
    public Response deletePet(int petId) {
        return given()
                .baseUri(baseURI)
                .delete(ApiPropertiesProvider.propertiesApi.getProperty("deletePet") + "/" + petId);
    }
}
