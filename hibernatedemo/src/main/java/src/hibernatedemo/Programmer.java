package src.hibernatedemo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


//@Table(name="devloper")//used to change table as developer
@Entity
public class Programmer {
	
	@Id
	private int empId;
	@Column(name="techstack")//use to change column name as teckstack
	private String technology;
	/*--this is written during manyTOmany relationship
	 * mapped by is used to avoid it's own mapping(without this in DB 2 tables will be created laptop_programmer & programmer_laptop)
	 * now by using mappedBy only one table is created programmer_laptop by avoiding it's own creation
	 */
	@OneToMany(fetch = FetchType.EAGER)//by default fetchTpe will be LAZY, if we want to specify Eager, we want to explicitly specify it
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
