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
	/*
	 * mapped by is used to avoid it's own mapping(without this in DB 2 tables will be created laptop_programmer & programmer_laptop)
	 * now by using mappedBy only one table is created programmer_laptop by avoiding it's own creation
	 */
	@ManyToMany(mappedBy = "laptops") 
	private List<Programmer> programmer;
	
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
	
	public List<Programmer> getProgrammer() {
		return programmer;
	}

	public void setProgrammer(List<Programmer> programmer) {
		this.programmer = programmer;
	}

	@Override
	public String toString() {
		return "Laptop [brand=" + brand + ", ram=" + ram + ", id=" + id + "]";
	}
}
