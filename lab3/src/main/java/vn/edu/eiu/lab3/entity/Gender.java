package vn.edu.eiu.lab3.entity;

public enum Gender {
    MALE("Nam"),
    FEMALE("Nu"),
    OTHER("Khac");

    private final String displayName;

    Gender(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}