package api;

public enum StandartPetStringTestData {

    PET_CATEGORY_NAME("Dogs"),
    PET_NAME("Tuzik"),
    PET_PHOTO_URL("https://i.pinimg.com/736x/27/3f/0d/273f0d23e6f581c2e41adaa60c7ac124.jpg"),
    PET_TAGS_NAME("testDog"),
    PET_STATUS("available");

    private String info;

    StandartPetStringTestData(String info) {
        this.info = info;
    }

    public String val() {
        return info;
    }
}
