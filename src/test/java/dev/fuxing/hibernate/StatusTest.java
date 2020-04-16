package dev.fuxing.hibernate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * @author Fuxing Loh
 * @since 2020-04-17 at 03:11
 */
class StatusTest {

    static Validator validator;

    @BeforeAll
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    static class Bean {

        @ValidEnum
        Status status;

        public Bean(Status status) {
            this.status = status;
        }

        public Status getStatus() {
            return status;
        }
    }

    @Test
    void valid() {
        Bean bean = new Bean(Status.DELETED);

        Set<ConstraintViolation<Bean>> violations = validator.validate(bean);
        Assertions.assertTrue(violations.isEmpty());
    }

    @Test
    void nullString() {
        Bean bean = new Bean(Status.fromValue("null"));

        Set<ConstraintViolation<Bean>> violations = validator.validate(bean);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    void nullEnum() {
        Bean bean = new Bean(Status.fromValue(null));

        Set<ConstraintViolation<Bean>> violations = validator.validate(bean);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    void nullInvalid() {
        Bean bean = new Bean(Status.fromValue("INVALID"));

        Set<ConstraintViolation<Bean>> violations = validator.validate(bean);
        Assertions.assertFalse(violations.isEmpty());
    }
}
