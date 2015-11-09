package com.joe.learn.annotation;


import java.lang.annotation.*;

@Documented
@Inherited
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldAnnotation {

	public String value() default "zhuli";

}
