package api;

import api.checks.BaseChecks;
import api.checks.DeleteChecks;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeletePetCardTest extends BaseTest{

    @Test
    @DisplayName("Успешное удаление карточки питомца")
    public void successfulDeletePetCard() {

        request.addNewPet(standartPet);

        Response response = request.deletePet(StandartPetIntTestData.PET_ID.val());
        BaseChecks.checkResponseCode(response, 200);
        DeleteChecks.checkInsideBodyStatusCode(response, 200);
        DeleteChecks.checkType(response, "unknown");
        DeleteChecks.checkMessage(response, String.valueOf(StandartPetIntTestData.PET_ID.val()));
    }
}
