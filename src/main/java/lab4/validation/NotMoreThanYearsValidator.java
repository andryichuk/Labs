package lab4.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class NotMoreThanYearsValidator implements ConstraintValidator<NotMoreThanYears, LocalDate> {

    private int annotationYears;

    @Override
    public void initialize(NotMoreThanYears notMoreThanYears) {
        this.annotationYears = notMoreThanYears.value();
    }

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintContext) {

        if (localDate == null)
            return true;

        long yearsBetween = Math.abs(ChronoUnit.YEARS.between(LocalDate.now(), localDate));
        boolean isValid = yearsBetween <= annotationYears;

        if (!isValid) {
            constraintContext.disableDefaultConstraintViolation();
            constraintContext.buildConstraintViolationWithTemplate("must be not more than " + annotationYears + " years")
                    .addConstraintViolation();
        }

        return isValid;
    }
}