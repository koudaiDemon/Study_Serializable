package com.cWww.project4;

import java.io.Serializable;

/**
 * ѧ����
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class Student implements Serializable{
	
	private int sno;//ѧ��
	private String name;//����
	private String sex;//�Ա�
	private int age;//����
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(int sno, String name, String sex, int age) {
		super();
		this.sno = sno;
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", name=" + name + ", sex=" + sex
				+ ", age=" + age + "]";
	}
	
}
