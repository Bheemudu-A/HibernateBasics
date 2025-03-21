package src.hibernatedemo;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		/*
		 * //1. Below steps are to store data(Java Objects) into database Company bm =
		 * new Company();
		 * 
		 * Configuration cfg = new Configuration();
		 * cfg.addAnnotatedClass(src.hibernatedemo.Company.class);
		 * cfg.configure();//used to bind xml properties to code
		 * 
		 * SessionFactory sf = cfg.buildSessionFactory();
		 * 
		 * //instead of above 4 lines we can make it as simple as below in single line
		 * SessionFactory sf = new Configuration().
		 * addAnnotatedClass(src.hibernatedemo.Company.class).
		 * configure().buildSessionFactory();
		 * 
		 * Session session = sf.openSession();
		 * 
		 * bm.setAge(28); bm.setDesignation("Senior Production Support Analyst");
		 * bm.setEmpName("Ramesh"); bm.setSalary(54000);
		 * 
		 * // session.save(bm); //save method is deprecated from hibernate 6, instead we
		 * can use persist // session.persist(bm); //merge is used to update the
		 * existing data session.merge(bm); // to commit the above object we need
		 * trasaction obj Transaction trans = session.beginTransaction();
		 * 
		 * trans.commit();
		 * 
		 * System.out.println(bm);
		 * 
		 * session.clear(); sf.close(); //close session & sessionFactory after complete
		 * of execution
		 * 
		 * // for readability iam commenting above code, in case of saving data to DB,
		 * use it //2. above steps are to store data into database & below steps are to
		 * fetch data from database
		 * 
		 * 
		 * Company com = null;
		 * 
		 * 
		 * SessionFactory sf1 = new Configuration().
		 * addAnnotatedClass(src.hibernatedemo.Company.class).
		 * configure().buildSessionFactory();
		 * 
		 * Session session1 = sf1.openSession();
		 * 
		 * //fetching data from database com = session1.get(Company.class, 26);
		 * 
		 * //transaction is very imp because without commit changes wont reflect in DB
		 * Transaction trans1 = session1.beginTransaction();
		 * 
		 * 
		 * //deleting data from database session1.remove(com);
		 * 
		 * trans1.commit(); session1.close(); sf1.close(); System.out.println(com);
		 */

		// -------------------------above code is about CRUD operations for now commenting it, do uncomment when you need it-----------------------

		
		SessionFactory sfy = new Configuration().
				addAnnotatedClass(src.hibernatedemo.Programmer.class).
				addAnnotatedClass(src.hibernatedemo.Laptop.class).
				configure().buildSessionFactory();
		
		Session sn = sfy.openSession();
		
		Laptop lpt = new Laptop();
		
		lpt.setBrand("HP");
		lpt.setRam(8);
		lpt.setId(101);
		
		Laptop lpt2 = new Laptop();
		
		lpt2.setBrand("Dell");
		lpt2.setRam(4);
		lpt2.setId(102);
		
		Programmer dev = new Programmer();
		
		dev.setEmpId(10043311);
		dev.setLaptop(Arrays.asList(lpt, lpt2));
		dev.setTechnology("Java");
		
		Programmer fron = new Programmer();
		
		fron.setEmpId(10043312);
		fron.setLaptop(Arrays.asList(lpt, lpt2));
		fron.setTechnology("JavaScript");
		
		
		lpt.setProgrammer(List.of(dev, fron));
		lpt2.setProgrammer(List.of(dev, fron));
		
		
		Transaction tn = sn.beginTransaction();
		
		sn.persist(dev);
		sn.persist(lpt);
		sn.persist(lpt2);
		sn.persist(fron);
		tn.commit();
		
		sn.close();
		sfy.close();
		
		System.out.println(dev);
		
	}
}
