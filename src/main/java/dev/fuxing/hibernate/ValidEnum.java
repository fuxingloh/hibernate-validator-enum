package dev.fuxing.hibernate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * Validate enum that are structured with nullable string.
 * Will fail if property is {@code null} or {@code "null"}.
 *
 * @author Fuxing Loh
 * @since 2019-06-26 at 02:54
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Constraint(validatedBy = EnumValidator.class)
public @interface ValidEnum {
    String message() default "enum is null";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

