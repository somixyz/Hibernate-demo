package hb.demo.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hb.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			int studentID = 4;

			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on the id: primary key
			System.out.println("\n Getting student with id: " + studentID);
			Student student = session.get(Student.class, studentID);

			// delete the student
			System.out.println("Deleting student: "+student);
//			session.delete(student);

			// commit the transaction
//			session.getTransaction().commit();

			
			//DELETE STUDENT 2nd APPROACH
			
			//delete student
			System.out.println("Deleting student id=2");
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			//commit transaction 
			session.getTransaction().commit();
			
			
			
			System.out.println("Done!");

		} finally {
			factory.close();
		}

	}

}
