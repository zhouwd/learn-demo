package com.joe.learn.annotation;


@ClassAnnotation(value = "zhouwd")
public class MethodAnnotationModel {
	private String userName;

	@MethodAnnotation(methodType = MethodAnnotation.MethodTypeEnum.TYPE2)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
