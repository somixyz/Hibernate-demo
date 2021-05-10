package hb.demo.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hb.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save JAVA object 
			// create 3 student objects
			System.out.println("Creating 3 student objects...");
			Student tempStudent = new Student("Luk", "Skajvoker", "pera@dr.com");
			Student tempStudent1 = new Student("Milan", "Milojevic", "milan@dr.com");
			Student tempStudent2 = new Student("Ilija", "Ilic", "ilija@dr.com");
			
			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the students...");
			session.save(tempStudent);
			session.save(tempStudent1);
			session.save(tempStudent2);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}

	}

}
