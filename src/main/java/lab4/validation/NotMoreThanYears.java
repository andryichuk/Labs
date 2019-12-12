package lab4.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NotMoreThanYearsValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotMoreThanYears {

    int value();

    String message() default "{lab4.service.NotMoreThanYears.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}