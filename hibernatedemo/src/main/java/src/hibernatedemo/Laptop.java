package src.hibernatedemo;

import java.util.List;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

//@Embeddable //used to make class as a type in Entity class
@Entity
public class Laptop {
	
	private String brand;
	private int ram;
	@Id
	private int id;
	
//	@ManyToOne
//	private Programmer programmer;
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public int getRam() {
		return ram;
	}
	
	public void setRam(int ram) {
		this.ram = ram;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	/*public Programmer getProgrammer() {
		return programmer;
	}

	public void setProgrammer(Programmer programmer) {
		this.programmer = programmer;
	}*/

	@Override
	public String toString() {
		return "Laptop [brand=" + brand + ", ram=" + ram + ", id=" + id + "]";
	}
}
