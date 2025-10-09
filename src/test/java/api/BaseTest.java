package api;

import api.model.NewPet;
import api.provider.PetProvider;
import api.requests.Request;
import api.testdata.StandartPetIntTestData;
import api.testdata.StandartPetStringTestData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


public abstract class BaseTest {

    protected Request request;
    protected NewPet standartPet;

    @BeforeEach
    public void setUp() {
        request = new Request();

        standartPet = PetProvider.createPet(StandartPetIntTestData.PET_ID.val(), StandartPetIntTestData.CATEGORY_ID.val(),
                StandartPetStringTestData.PET_CATEGORY_NAME.val(), StandartPetStringTestData.PET_NAME.val(),
                StandartPetStringTestData.PET_PHOTO_URL.val(), StandartPetIntTestData.TAGS_ID.val(), StandartPetStringTestData.PET_TAGS_NAME.val(),
                StandartPetStringTestData.PET_STATUS.val());
    }

    @AfterEach
    public void tearDown() {
        request.deletePet(StandartPetIntTestData.PET_ID.val());
    }
}