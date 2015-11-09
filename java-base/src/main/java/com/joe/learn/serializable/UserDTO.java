package com.joe.learn.serializable;

import java.io.Serializable;

public class UserDTO extends ParentDTO implements Serializable {

	private String userName;
	private Integer age;
	private transient String addr; //如果某个字段不需要序列化，那么需要使用 transient 修饰

	private transient DeptDTO deptDTO;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public DeptDTO getDeptDTO() {
		return deptDTO;
	}

	public void setDeptDTO(DeptDTO deptDTO) {
		this.deptDTO = deptDTO;
	}

	@Override
	public String toString() {
		return "UserDTO{" +
				"userName='" + userName + '\'' +
				", age=" + age +
				", addr='" + addr + '\'' +
				", deptDTO=" + deptDTO +
				"} " + super.toString();
	}
}
