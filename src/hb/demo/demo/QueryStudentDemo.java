package hb.demo.demo;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hb.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try { 

			// start a transaction
			session.beginTransaction();
			
			//query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			//display the students
			displayStudents(theStudents);
			
			//same thing above, but with 2nd approach
//			for (Iterator iterator = theStudents.iterator(); iterator.hasNext();) {
//				Student student = (Student) iterator.next();
//				System.out.println(student);
//			}
			
			//query students: lastName ='Ilic'
			theStudents = session.createQuery("from Student s where s.lastName='Ilic'").getResultList();
			
			//display the students , who have last name of Ilic
			System.out.println("\n\nthe students , who have last name of Ilic");
			displayStudents(theStudents);
			
			//query students: lastName='Ilic' OR firstName='Petar'
			theStudents = session.createQuery("from Student s where s.lastName='Ilic' OR s.firstName='Milan'").getResultList();
			
			//display the students
			System.out.println("\n\nthe students , who have last name of Ilic  OR firstName=Milan");
			displayStudents(theStudents);
			
			
			//query students where email LIKE '%.com'
			theStudents = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
			
			//display the students where email ends gmail.com
			System.out.println("\n\nthe students where email ends gmail.com");
			displayStudents(theStudents);
			
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

}
