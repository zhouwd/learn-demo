package com.joe.learn.serializable;

import java.io.*;

public class SerializableTest {


	public static void main(String[] args) {
		System.out.println("Java Serializable");
		UserDTO dto = new UserDTO();
		dto.setCode("10010");
		dto.setAge(10);
		dto.setUserName("joe");
		dto.setAddr("beijing changping tiantongyuan");

		//如果该field被赋值，并且该字段没有被标注transient，那么在序列化的时候，该字段也将被序列化，但是由于该对象没有继承序列化接口，因此此处会抛出异常。
		//解决的方法有三个：1，设置该字段为null，不影响序列化；2，该字段加入修饰符 transient ，表示不序列化该字段；3，该字段的对象实现序列化接口。
		dto.setDeptDTO(new DeptDTO(1,"it","cto"));
		System.out.println("before serializable:"+dto.toString());
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("d:/test.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);
			objectOutputStream.writeObject(dto);
			System.out.println("Serializable success");
			fos.close();
			objectOutputStream.close();


			FileInputStream fis = new FileInputStream("d:/test.txt");
			ObjectInputStream objectInputStream = new ObjectInputStream(fis);
			UserDTO dtoTemp = (UserDTO) objectInputStream.readObject();
			System.out.println("after serializable:"+dtoTemp.toString());
			System.out.println("读取序列化成功");
			objectInputStream.close();
			fis.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void netSerializable(){

		System.out.println("Java序列化测试类");

		UserDTO testBo = new UserDTO();
		testBo.setAge(15);

		testBo.setUserName("zhuli");
		testBo.setAddr("beijing changping");
		try {
			//如果在网络上传输，一般使用ByteArrayOutputStream, 将对象序列化成byte数组，然后再进行传输。
			ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
			ObjectOutputStream byteOutObj = new ObjectOutputStream(byteOut);
			byteOutObj.writeObject(testBo);
			byte[] testBoByte = byteOut.toByteArray();
			System.out.println("序列化成功");

			//读取byteArray
			ByteArrayInputStream byteIn = new ByteArrayInputStream(testBoByte);
			ObjectInputStream  byteInObj = new ObjectInputStream(byteIn);
			UserDTO testBo3= (UserDTO) byteInObj.readObject();
			System.out.println(testBo3.toString());
			System.out.println("读取序列化成功");
			byteInObj.close();
			byteIn.close();
			byteOut.close();
			byteOutObj.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
