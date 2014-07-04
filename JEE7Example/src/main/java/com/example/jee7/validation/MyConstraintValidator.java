package com.example.jee7.validation;

import java.util.HashSet;
import java.util.Set;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author David EXCOFFIER <david.excoffier@st.com>
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, String> {

    private String country;

    private Set<String> validDept = new HashSet<>();

    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        this.country = constraintAnnotation.country();
        if (!"fr".equalsIgnoreCase(country)) {
            throw new IllegalStateException("....");
        }
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return validDept.contains(value.substring(0, 2));
    }

}
