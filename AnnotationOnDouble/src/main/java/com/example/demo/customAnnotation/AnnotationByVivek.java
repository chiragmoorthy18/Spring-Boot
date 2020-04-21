package com.example.demo.customAnnotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AnnotationByVivek implements ConstraintValidator<vivekAnnotation, String> {
  
	public void initialize(vivekAnnotation constraint) {
    }
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return false;
	}

}
