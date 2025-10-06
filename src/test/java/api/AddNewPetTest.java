package api;

import api.action.BaseAction;
import api.action.PetCardAction;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AddNewPetTest extends BaseTest {

    @Test
    @DisplayName("Успешное добавление нового питомца")
    public void successfulAddNewPet() {

        Response response = request.addNewPet(standartPet);

        BaseAction.checkResponseCode(response, 200);
        PetCardAction.checkPetId(response, StandartPetIntTestData.PET_ID.val());
        PetCardAction.checkCategoryId(response, StandartPetIntTestData.CATEGORY_ID.val());
        PetCardAction.checkCategoryName(response, StandartPetStringTestData.PET_CATEGORY_NAME.val());
        PetCardAction.checkPetName(response, StandartPetStringTestData.PET_NAME.val());
        PetCardAction.checkPhotoUrlsList(response, 0, StandartPetStringTestData.PET_PHOTO_URL.val());
        PetCardAction.checkTagsList(response, 0, StandartPetIntTestData.TAGS_ID.val(), StandartPetStringTestData.PET_TAGS_NAME.val());
        PetCardAction.checkPetStatus(response, StandartPetStringTestData.PET_STATUS.val());
    }
}