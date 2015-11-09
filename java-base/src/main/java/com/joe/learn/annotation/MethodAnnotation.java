package com.joe.learn.annotation;

import java.lang.annotation.*;

@Documented
@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodAnnotation {

	public enum MethodTypeEnum{
		TYPE1,TYPE2
	}

	public MethodTypeEnum methodType() default MethodTypeEnum.TYPE1;

}
