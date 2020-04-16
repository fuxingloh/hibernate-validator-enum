package dev.fuxing.hibernate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Fuxing Loh
 * @since 2019-06-26 at 02:54
 */
@SuppressWarnings("rawtypes")
public class EnumValidator implements ConstraintValidator<ValidEnum, Enum> {
    @Override
    public boolean isValid(Enum value, ConstraintValidatorContext context) {
        if (value == null) return false;
        return !value.toString().equals("null");
    }
}
