package pl.najavie.validators;

import com.google.common.collect.Lists;

import java.util.List;

public class NameRepository {

    private NameRepository() {
        super();
    }


    public static final List<GenderName> names = Lists.newArrayList(
            new GenderName("Jan",Gender.MALE),
            new GenderName("Anna",Gender.FEMALE),
            new GenderName("Piotr",Gender.MALE),
            new GenderName("Brian",Gender.MALE),
            new GenderName("Jessica",Gender.FEMALE)
    );



}
