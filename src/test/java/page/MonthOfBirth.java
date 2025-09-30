package page;

public enum MonthOfBirth {
    JANUARY("January"),
    FEBRUARY("February"),
    MARCH("March"),
    APRIL("April"),
    MAY("May"),
    JUNE("June"),
    JULY("July"),
    AUGUST("August"),
    SEPTEMBER("September"),
    OCTOBER("October"),
    NOVEMBER("November"),
    DECEMBER("December");

    private final String name;

    MonthOfBirth(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
