package hb.demo.jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {

		try {
			String jdbcURL = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
			String user = "hbstudent";
			String pass = "hbstudent";
			System.out.println("Connceting to database: " + jdbcURL);
			
			Connection con = DriverManager.getConnection(jdbcURL, user, pass);

			System.out.println("Connection succesful ");
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
