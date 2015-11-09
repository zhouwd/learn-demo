package com.joe.learn.annotation;


import java.lang.annotation.*;

@Documented	//doc
@Inherited	//extend by child class
@Target({ElementType.TYPE, ElementType.METHOD})  //used by class and method
@Retention(RetentionPolicy.RUNTIME)  // used when run time.
public @interface ClassAnnotation {
	public String value() default "joe";
}
