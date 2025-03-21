package src.hibernatedemo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
//@Table(name="devloper")//used to change table as developer
public class Programmer {
	
	@Id
	private int empId;
	@Column(name="techstack")//use to change column name as teckstack
	private String technology;
	
	@ManyToMany
	private List<Laptop> laptops;
	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public List<Laptop> getLaptop() {
		return laptops;
	}
	public void setLaptop(List<Laptop> laptops) {
		this.laptops = laptops;
	}
	
	@Override
	public String toString() {
		return "Programmer [empId=" + empId + ", technology=" + technology + ", laptops=" + laptops + "]";
	}

}
