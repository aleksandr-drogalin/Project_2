package api.checks;

import api.model.NewPet;
import api.model.TagsNewPet;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PetCardChecks {

    @Step("Проверка, что в теле ответа содержится id питомца {expectedId}")
    public static void checkPetId(Response response, int expectedId) {
        response.then().assertThat().body("id",equalTo(expectedId));
    }

    @Step("Проверка, что в теле ответа содержится id категории {expectedId}")
    public static void checkCategoryId(Response response, int expectedId) {
        response.then().assertThat().body("category.id", equalTo(expectedId));
    }

    @Step("Проверка, что в теле ответа содержится название категории {expectedName}")
    public static void checkCategoryName(Response response, String expectedName) {
        response.then().assertThat().body("category.name", equalTo(expectedName));
    }

    @Step("Проверка, что в теле ответа содержится имя питомца {expectedName}")
    public static void checkPetName(Response response, String expectedName) {
        response.then().assertThat().body("name", equalTo(expectedName));
    }

    @Step("Проверка, что в теле ответа возвращается список URL фото {expectedURL}")
    public static void checkPhotoUrlsList(Response response, int checkIndexOfList, String expectedURL) {
        NewPet responsePet = response.body().as(NewPet.class);
        List<String> listUrl = responsePet.getPhotoUrls();
        assertThat(listUrl.get(checkIndexOfList)).isEqualTo(expectedURL);
    }

    @Step("Проверка, что в теле ответа возвращается список тегов {expectedId}, {expectedName}")
    public static void checkTagsList(Response response, int checkedIndexOfList, int expectedId, String expectedName) {
        NewPet responsePet = response.body().as(NewPet.class);
        List<TagsNewPet> tagsResponsePetList = responsePet.getTags();
        TagsNewPet tagsResponsePet = tagsResponsePetList.get(checkedIndexOfList);
        assertAll(
                () -> assertThat(tagsResponsePet.getId()).isEqualTo(expectedId),
                () -> assertThat(tagsResponsePet.getName()).isEqualTo(expectedName)
        );
    }

    @Step("Проверка, что в теле ответа возвращается статус {expectedStatus}")
    public static void checkPetStatus(Response response, String expectedStatus) {
        response.then().body("status", equalTo(expectedStatus));
    }
}
