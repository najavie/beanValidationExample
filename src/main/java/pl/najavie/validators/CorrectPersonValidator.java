package pl.najavie.validators;

import pl.najavie.Person;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CorrectPersonValidator implements ConstraintValidator<CorrectNameAndGender, Person> {
   public void initialize(CorrectNameAndGender constraint) {
   }

   public boolean isValid(Person person, ConstraintValidatorContext context) {


      final Gender gender = person.getGender();
      final String name = person.getName();

      return NameRepository.names.stream().anyMatch(genderName -> genderName.getName().equals(name) && genderName.getGender().equals(gender));

   }
}
