package com.joe.learn.annotation;

import java.lang.reflect.Method;

public class MethodMainTest {

	public static void main(String[] args) {
		Class<MethodAnnotationModel> annotationModelClass = MethodAnnotationModel.class;
		Method[] methods = annotationModelClass.getDeclaredMethods();
		for (Method method : methods) {
			if (!"getUserName".equals(method.getName())) {
				continue;
			}
			if (method.isAnnotationPresent(MethodAnnotation.class)) {
				System.out.println("this is a method annotation");
				MethodAnnotation methodAnnotation = method.getAnnotation(MethodAnnotation.class);
				if (methodAnnotation != null) {
					if (MethodAnnotation.MethodTypeEnum.TYPE1.equals(methodAnnotation.methodType())) {
						System.out.println("this is type1");
					} else {
						System.out.println("this is type2");
					}
				}
			} else {
				System.out.println("this is not a method annotation");
			}
		}
	}
}
