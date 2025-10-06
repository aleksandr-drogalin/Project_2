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

        CategoryNewPet category = new CategoryNewPet(StandartPetIntTestData.CATEGORY_ID.val(), StandartPetStringTestData.PET_CATEGORY_NAME.val());
        List<String> photoUrls = new ArrayList<>();
        photoUrls.add(StandartPetStringTestData.PET_PHOTO_URL.val());
        TagsNewPet tag1 = new TagsNewPet(StandartPetIntTestData.TAGS_ID.val(), StandartPetStringTestData.PET_TAGS_NAME.val());
        List<TagsNewPet> tags = new ArrayList<>();
        tags.add(tag1);
        standartPet = new NewPet(StandartPetIntTestData.PET_ID.val(), category, StandartPetStringTestData.PET_NAME.val(), photoUrls, tags, StandartPetStringTestData.PET_STATUS.val());
    }

    @AfterEach
    public void tearDown() {
        request.deletePet(StandartPetIntTestData.PET_ID.val());
    }
}