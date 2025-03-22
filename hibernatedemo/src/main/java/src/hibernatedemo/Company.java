package src.hibernatedemo;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Cacheable
public class Company {
	
	@Id
	private int age;
	private String empName;
	private double salary;
	private String designation;
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Company [age=" + age + ", empName=" + empName + ", salary=" + salary + ", designation=" + designation
				+ "]";
	}
}
