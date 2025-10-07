package api.testdata;

public enum StandartPetIntTestData {

    PET_ID(1637),
    CATEGORY_ID(3),
    TAGS_ID(1);

    private int info;

    StandartPetIntTestData(int info) {
        this.info = info;
    }

    public int val() {
        return info;
    }
}
