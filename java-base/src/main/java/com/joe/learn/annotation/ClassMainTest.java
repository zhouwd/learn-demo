package com.joe.learn.annotation;

public class ClassMainTest {
	public static void main(String[] args) {
		Class<ClassAnnotationModel> testClazz = ClassAnnotationModel.class;

		if (testClazz.isAnnotationPresent(ClassAnnotation.class)) {
			System.out.println("this is a annotion class.");


			ClassAnnotation testClazzAnnotation = testClazz.getAnnotation(ClassAnnotation.class);
			if (testClazzAnnotation != null) {
				System.out.println("value:" + testClazzAnnotation.value());
			} else {
				System.out.println("null");
			}
		}else{
			System.out.println("this is not annotion class.");
		}
	}
}
