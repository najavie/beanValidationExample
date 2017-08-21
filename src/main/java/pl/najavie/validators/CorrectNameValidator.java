package pl.najavie.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CorrectNameValidator implements ConstraintValidator<CorrectName, String> {
    public void initialize(CorrectName constraint) {
    }

    public boolean isValid(String name, ConstraintValidatorContext context) {
      return NameRepository.names.stream().map(GenderName::getName).anyMatch((element) -> element.equals(name));
   }
}
