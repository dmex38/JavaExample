package com.example.jee7.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author David EXCOFFIER <david.excoffier@st.com>
 */
@Documented
@Constraint(validatedBy = MyConstraintValidator.class)
@Target(value = {ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MyConstraint {

    String message() default "";

    String[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};

    String country() default "fr";
}
