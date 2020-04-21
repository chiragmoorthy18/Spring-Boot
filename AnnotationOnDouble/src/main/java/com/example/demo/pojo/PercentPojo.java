package com.example.demo.pojo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;

import com.example.demo.customAnnotation.DoubleRange;
import com.example.demo.customAnnotation.vivekAnnotation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PercentPojo {
	//@Id
	String id;
 //   @Range(min=0,max=100)
	Double wrapperDoublePercent;
   // @Min(value = 0)
  //  @Max(value = 100)
	Float wrapperFloatPercent;
   // @Min(value = 0)
   // @Max(value = 100)
	double doublePercent;
   // @Range(min = 0,max = 100)
	float floatPercent;
    
    
   // @vivekAnnotation
    String name;
    
    @DoubleRange(min = 0.0,max = 100.0)
    Double customAttribute;
   
    

}
