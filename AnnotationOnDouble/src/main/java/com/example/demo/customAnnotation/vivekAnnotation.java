package com.example.demo.customAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.Valid;

import com.example.demo.customAnnotation.AnnotationByVivek;

@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy =  AnnotationByVivek.class)
public @interface vivekAnnotation { 
	String message() default "{Vivek validation not valid}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
