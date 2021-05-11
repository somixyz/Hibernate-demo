package hb.demo.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hb.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try { 
			
			
			int studentID = 1;
			
			//now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			//retrieve student based on the id: primary key
			System.out.println("\n Getting student with id: "+ studentID); 

			
			Student student = session.get(Student.class, studentID);
			
			System.out.println("Updating student...");
			
			student.setFirstName("Zivojin");
			
			 
			//commit the transaction
			session.getTransaction().commit();
			
			
			
			//NEW CODE
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//update email for all students
			System.out.println("update email for first and fourth student ");
			
			session.createQuery("update Student set email='pikabii@gmail.com' where (id=1 AND id=3)").executeUpdate();
			
		 	
			//commit the transaction
			session.getTransaction().commit();
			
			
			
			
			
			System.out.println("Done!");

		} finally {
			factory.close();
		}

	}

}
