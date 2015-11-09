package com.joe.learn.serializable;

public class ParentDTO {

	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "ParentDTO{" +
				"code='" + code + '\'' +
				'}';
	}
}
