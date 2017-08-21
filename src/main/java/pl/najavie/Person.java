package pl.najavie;

import org.hibernate.validator.constraints.pl.NIP;
import org.hibernate.validator.constraints.pl.PESEL;
import pl.najavie.validators.Adult;
import pl.najavie.validators.CorrectName;
import pl.najavie.validators.CorrectNameAndGender;
import pl.najavie.validators.Gender;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;


@CorrectNameAndGender
public class Person {

    @NotBlank
    @CorrectName
    private String name;

    @NotBlank
    private String lastName;

    @Past
    @Adult
    private Date dateOfBirth;

    @NotNull
    @PESEL
    private String pesel;

    @NIP
    private String nip;

    @Valid
    private Address address;


    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPesel() {
        return pesel;
    }

    public String getNip() {
        return nip;
    }

    public Address getAddress() {
        return address;
    }

    public Person(@NotBlank String name, @NotBlank String lastName, @Past Date dateOfBirth, @NotNull @PESEL String pesel, @NIP String nip, Address address) {
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.pesel = pesel;
        this.nip = nip;
        this.address = address;
    }

    public Gender getGender() {

        if(pesel.length() != 11) {
            return null;
        }

        final int genderElement = Integer.parseInt(String.valueOf(pesel.charAt(9)));
        if(genderElement %2 ==0) {
            return Gender.FEMALE;
        }
        return Gender.MALE;
    }
}
