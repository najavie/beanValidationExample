package pl.najavie.validators;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CorrectPersonValidator.class)
public @interface CorrectNameAndGender {

    String message() default "Imie nie pasuje do płci";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
