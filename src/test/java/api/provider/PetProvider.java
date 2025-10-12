package api.provider;

import api.model.CategoryNewPet;
import api.model.NewPet;
import api.model.TagsNewPet;

import java.util.List;

public class PetProvider {

    public static NewPet createPet(int petId, int categoryId, String categoryName, String name, String photoUrls,
                                   int tagsId, String tagsName, String status) {

        CategoryNewPet categoryNewPet = new CategoryNewPet(categoryId, categoryName);
        List<String> photoUrlsPetList = List.of(photoUrls);
        TagsNewPet tagsNewPet = new TagsNewPet(tagsId, tagsName);
        List<TagsNewPet> tagsNewPetList = List.of(tagsNewPet);

        return new NewPet(petId, categoryNewPet, name, photoUrlsPetList, tagsNewPetList, status);
    }
}
