package com.example.jee7.validation;

import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author David EXCOFFIER <david.excoffier@st.com>
 */
@Pattern(regexp = "[0-9]*")
@Size(min = 5, max = 5)
@Constraint(validatedBy = {})
// @ReportAsSingleViolation 
@Documented
@Target({ANNOTATION_TYPE, METHOD, FIELD, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
public @interface MyComposedConstrain {

    String message() default "Wrong zipcode";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @OverridesAttribute.List({
        @OverridesAttribute(constraint = Size.class, name = "min"),
        @OverridesAttribute(constraint = Size.class, name = "max")})
    int size() default 5;

    @OverridesAttribute(constraint = Size.class, name = "message")
    String sizeMessage() default "{com.acme.constraint.FrenchZipcode.zipcode.size}";

    @OverridesAttribute(constraint = Pattern.class, name = "message")
    String numberMessage() default "{com.acme.constraint.FrenchZipcode.number.size}";

    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
    @Retention(RUNTIME)
    @Documented
    @interface List {

        MyComposedConstrain[] value();
    }
}
