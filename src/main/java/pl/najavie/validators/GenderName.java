package pl.najavie.validators;

public class GenderName {

    private final String name;
    private final Gender gender;


    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public GenderName(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }
}
