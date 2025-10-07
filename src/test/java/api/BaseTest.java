package api;

import api.model.CategoryNewPet;
import api.model.NewPet;
import api.model.TagsNewPet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseTest {

    protected Request request;
    protected NewPet standartPet;

    @BeforeEach
    public void setUp() {
        request = new Request();

        CategoryNewPet categoryStandartPet = new CategoryNewPet(StandartPetIntTestData.CATEGORY_ID.val(), StandartPetStringTestData.PET_CATEGORY_NAME.val());
        List<String> photoUrlsStandartPet = new ArrayList<>(List.of(StandartPetStringTestData.PET_PHOTO_URL.val()));
        TagsNewPet tag1StandartPet = new TagsNewPet(StandartPetIntTestData.TAGS_ID.val(), StandartPetStringTestData.PET_TAGS_NAME.val());
        List<TagsNewPet> tagsStandartPetList = new ArrayList<>(List.of(tag1StandartPet));

        standartPet = new NewPet(StandartPetIntTestData.PET_ID.val(), categoryStandartPet, StandartPetStringTestData.PET_NAME.val(), photoUrlsStandartPet, tagsStandartPetList, StandartPetStringTestData.PET_STATUS.val());
    }

    @AfterEach
    public void tearDown() {
        request.deletePet(StandartPetIntTestData.PET_ID.val());
    }
}