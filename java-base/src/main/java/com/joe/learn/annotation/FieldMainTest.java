package com.joe.learn.annotation;

import java.lang.reflect.Field;

public class FieldMainTest {


	public static void main(String[] args) {

		FieldAnnotationModel fieldAnnotationModel = new FieldAnnotationModel();
		Class<FieldAnnotationModel> modelClass = FieldAnnotationModel.class;

		//getFields()   //获取该类中定义的public Field
		Field[] fields = modelClass.getDeclaredFields();//获取该类中定义的所有的Field。
		for (Field field : fields) {
			if ("userName".equals(field.getName()) && field.isAnnotationPresent(FieldAnnotation.class)) {
				System.out.println("this is a field annotation");
				FieldAnnotation fieldAnnotation = field.getAnnotation(FieldAnnotation.class);
				if(fieldAnnotation!=null){
					field.setAccessible(true);//通过反射给私有变量赋值。
					try {
						field.set(fieldAnnotationModel,fieldAnnotation.value());
						System.out.println("value:" + fieldAnnotationModel.getUserName());
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}else{
				System.out.println("this is not a field annotation");
			}
		}


	}

}
