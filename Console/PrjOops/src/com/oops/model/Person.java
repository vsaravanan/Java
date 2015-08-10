package com.oops.model;

public class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public int hashCode() {
//		return age + name.hashCode();
		
		final int prime = 31;
		int result = 1;
		result = prime * result + age + name.hashCode();
		return result;
		
		}	

//	public boolean equals(Object o) {
//		if ((o instanceof Person) && ((Person) o).getAge() == age &&
//				((Person) o).getName().equals(this.getName()))
//			return true;
//		return false;
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		//if (this.getClass() != obj.getClass())
		if (! (obj instanceof Person)) 
			return false;
		Person other = (Person) obj;
		if (! name.equals(other.getName()))
			return false;
		if (age != other.getAge())
			return false;
		return true;
	}
	
	public String getName() {
		return name;
	}
}