package ui.page;

public enum Gender {

    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other");

    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String val() {
        return gender;
    }

}
