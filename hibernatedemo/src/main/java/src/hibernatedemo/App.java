package src.hibernatedemo;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.Query;

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

	/*	SessionFactory sfy = new Configuration().
				addAnnotatedClass(src.hibernatedemo.Programmer.class).
				addAnnotatedClass(src.hibernatedemo.Laptop.class).
				configure().buildSessionFactory();
		
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
		
		
		
	//	lpt.setProgrammer(dev);
	//	lpt2.setProgrammer(dev);
		
		
		
		Session sn = sfy.openSession();
		
		
		Transaction tn = sn.beginTransaction();
		
		sn.persist(dev);
		sn.persist(lpt);
		sn.persist(lpt2);
		tn.commit();
		
		sn.close();
		
		Session newSs = sfy.openSession();
		
		Programmer programer = newSs.get(Programmer.class, 10043311);
		
		newSs.close();
		
		sfy.close();
		
		System.out.println(dev); */
		
		//2. till now(above) relation ships & Eager Fetch was done, below code is to get idea of HQL
		
		SessionFactory sftr = new Configuration().
				addAnnotatedClass(src.hibernatedemo.Company.class).
				configure().buildSessionFactory();
		
		Session sn = sftr.openSession();
		
	/*	Company cmny = new Company();
		
		cmny.setAge(26);
		cmny.setDesignation("Java Developer");
		cmny.setEmpName("Srinivas");
		cmny.setSalary(60000);*/
		

		String age = "25";
		
		
		Query<Company> query =  sn.createQuery("From Company where age =?1");
		
		query.setParameter(1, age);
		List<Company> result = query.getResultList();
		
		System.out.println("result: "+result);
		
		  
		//get vs load
		
		//get is eager loading
	//	Company com =  sn.get(Company.class, 26);
	//	System.out.println(com);
		
		//lazy loading, until you print the result, background query wont trigger
		Company com = sn.load(Company.class, 26);	
	//	System.out.println(com);
		
		//note:load method is deprecated so instead of load we can use byId method for lazy loading	
		Company com1 = sn.byId(Company.class).getReference(28);
	//	System.out.println(com1);
		
		//--------L2 Cache-----------------
		/*
		 * to achieve 2nd level cache add external cache ex: EhCache dependency & add annotation @Cacheable on entity class, to make it work
		 * make purpose of 2nd level cache is even though if you fire queries from different sessions, in background in will load query only once 
		 */
		Company l1 =  sn.get(Company.class, 26);
		System.out.println("l1: "+l1);
		sn.close();
		
		Session sess2 = sftr.openSession();
		
		Company l2 = sess2.get(Company.class, 26);
		System.out.println("l2: "+l2);
		
	//	sn.persist(cmny);
		
	//	Transaction tns = sn.beginTransaction();
		
 //	tns.commit();
		
	//	System.out.println(cmny);
	}
}
