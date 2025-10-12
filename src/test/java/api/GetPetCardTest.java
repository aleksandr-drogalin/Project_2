package api;

import api.checks.BaseChecks;
import api.checks.PetCardChecks;
import api.testdata.StandartPetIntTestData;
import api.testdata.StandartPetStringTestData;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GetPetCardTest extends BaseTest{

    @Test
    @DisplayName("Успешное получение карточки питомца по его id")
    public void successfulGetPetCard() {

        request.addNewPet(standartPet);
        Response response = request.getPet(StandartPetIntTestData.PET_ID.val());

        BaseChecks.checkResponseCode(response, 200);
        PetCardChecks.checkPetId(response, StandartPetIntTestData.PET_ID.val());
        PetCardChecks.checkCategoryId(response, StandartPetIntTestData.CATEGORY_ID.val());
        PetCardChecks.checkCategoryName(response, StandartPetStringTestData.PET_CATEGORY_NAME.val());
        PetCardChecks.checkPetName(response, StandartPetStringTestData.PET_NAME.val());
        PetCardChecks.checkPhotoUrlsList(response, 0, StandartPetStringTestData.PET_PHOTO_URL.val());
        PetCardChecks.checkTagsList(response, 0, StandartPetIntTestData.TAGS_ID.val(), StandartPetStringTestData.PET_TAGS_NAME.val());
        PetCardChecks.checkPetStatus(response, StandartPetStringTestData.PET_STATUS.val());
    }
}
