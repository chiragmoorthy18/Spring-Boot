package com.example.demo.customAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Target({ElementType.METHOD,ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DoubleRangeValidator.class)
public @interface DoubleRange {
	
	String message() default "Range must be between 0 to 100";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
	
	
	double min();
	double max();
	

}
