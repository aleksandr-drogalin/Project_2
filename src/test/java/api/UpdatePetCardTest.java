package api;

import api.checks.BaseChecks;
import api.checks.PetCardChecks;
import api.model.NewPet;
import api.provider.PetProvider;
import api.testdata.StandartPetIntTestData;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class UpdatePetCardTest extends BaseTest{

    private final int CATEGORY_ID_TEST_PET = 2;
    private final String CATEGORY_NAME_TEST_PET = "Cats";
    private final String PET_NAME_TEST_PET = "Boris";
    private final String URL_PHOTO_TEST_PET = "https://cdn.dribbble.com/users/67308/screenshots/1233995/digital-3_1.png";
    private final int TAGS_ID_TEST_PET = 2;
    private final String TAGS_NAME_TEST_PET = "Test Cat";
    private final String STATUS_TEST_PET = "reserved";

    @Test
    @DisplayName("Успешное обновление карточки питомца")
    public void successfulUpdatePetCard() {

        request.addNewPet(standartPet);

        NewPet testPet = PetProvider.createPet(StandartPetIntTestData.PET_ID.val(), CATEGORY_ID_TEST_PET, CATEGORY_NAME_TEST_PET, PET_NAME_TEST_PET,
                URL_PHOTO_TEST_PET, TAGS_ID_TEST_PET, TAGS_NAME_TEST_PET, STATUS_TEST_PET);

        Response response = request.updatePet(testPet);

        BaseChecks.checkResponseCode(response, 200);
        PetCardChecks.checkPetId(response, StandartPetIntTestData.PET_ID.val());
        PetCardChecks.checkCategoryId(response, CATEGORY_ID_TEST_PET);
        PetCardChecks.checkCategoryName(response, CATEGORY_NAME_TEST_PET);
        PetCardChecks.checkPetName(response, PET_NAME_TEST_PET);
        PetCardChecks.checkPhotoUrlsList(response, 0, URL_PHOTO_TEST_PET);
        PetCardChecks.checkTagsList(response, 0, TAGS_ID_TEST_PET, TAGS_NAME_TEST_PET);
        PetCardChecks.checkPetStatus(response, STATUS_TEST_PET);
    }
}
