package com.akshat.model;
import java.util.*;

public class Employee {
	
	private long id;
	private String name;
	private int age;
	private Date date_of_birth;
	
	public Employee()
	{
		
	}
	
	public Employee(long id, String name, int age, Date date_of_birth) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.date_of_birth = date_of_birth;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	
	

}
