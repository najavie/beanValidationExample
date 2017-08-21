package pl.najavie.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class AdultValidator implements ConstraintValidator<Adult, Date> {
   public void initialize(Adult constraint) {
   }

    @Override
    public boolean isValid(Date date, ConstraintValidatorContext constraintValidatorContext) {

        final LocalDate from = LocalDate.from(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

        final LocalDate now = LocalDate.now();

        return now.minusYears(18).isAfter(from);

    }


}
