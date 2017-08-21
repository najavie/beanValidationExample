package pl.najavie;

import junit.framework.Assert;
import junit.framework.TestCase;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Set;

public class PersonTest extends TestCase {

    final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    final Validator validator = validatorFactory.getValidator();

    public void testCorrectPerson() {


        Date dateOfBirth = Date.from(LocalDate.of(1992,8,29).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        Person person = new Person("Jessica","Kowalska", dateOfBirth,"92082901340","7655702637",new Address("jasna 12, Gdynia"));
        final Set<ConstraintViolation<Person>> personConstraintViolations = validator.validate(person);

        Assert.assertTrue(personConstraintViolations.isEmpty());


    }


    public void testIncorrectPersonAge() {


        Date dateOfBirth = Date.from(LocalDate.of(2013,8,29).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        Person person = new Person("Brian","Kowalski", dateOfBirth,"13282905413","7655702637",new Address("jasna 12, Gdynia"));
        final Set<ConstraintViolation<Person>> personConstraintViolations = validator.validate(person);

        Assert.assertFalse(personConstraintViolations.isEmpty());
        Assert.assertTrue(personConstraintViolations.size() == 1);
        Assert.assertTrue(personConstraintViolations.stream().anyMatch(element -> element.getMessage().equals("Nie jest pełnoletni(a)")));


    }

    public void testIncorrectName() {

        Date dateOfBirth = Date.from(LocalDate.of(1992,8,29).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        Person person = new Person("Karol","Kowalski", dateOfBirth,"87082913235","7655702637",new Address("jasna 12, Gdynia"));
        final Set<ConstraintViolation<Person>> personConstraintViolations = validator.validate(person);

        Assert.assertFalse(personConstraintViolations.isEmpty());
        Assert.assertTrue(personConstraintViolations.size() == 2);
        Assert.assertTrue(personConstraintViolations.stream().anyMatch(element -> element.getMessage().equals("Nieprawidłowe imię")));
        Assert.assertTrue(personConstraintViolations.stream().anyMatch(element -> element.getMessage().equals("Imie nie pasuje do płci")));

    }

    public void testIncorrectAddress() {

        Date dateOfBirth = Date.from(LocalDate.of(1992,8,29).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        Person person = new Person("Jessica","Kowalska", dateOfBirth,"92082901340","7655702637",new Address(null));
        final Set<ConstraintViolation<Person>> personConstraintViolations = validator.validate(person);

        Assert.assertFalse(personConstraintViolations.isEmpty());
        Assert.assertTrue(personConstraintViolations.size() == 1);
        Assert.assertTrue(personConstraintViolations.stream().anyMatch(element -> element.getMessage().equals("must not be null")));

    }



}