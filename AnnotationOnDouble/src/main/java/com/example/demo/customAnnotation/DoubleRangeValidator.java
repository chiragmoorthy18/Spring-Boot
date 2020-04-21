package com.example.demo.customAnnotation;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DoubleRangeValidator implements ConstraintValidator<DoubleRange, Double>{
    
	private Double min;
	private Double max;
	public void initialize(DoubleRange constraint) {
		min = constraint.min();
		max = constraint.max();
    }
	@Override
	public boolean isValid(Double value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return  value >= min && value <= max ? true:false;
	}

}
