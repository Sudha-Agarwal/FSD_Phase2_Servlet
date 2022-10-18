package Runner;

import java.sql.Date;
import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import persistence.Department;
import persistence.Employee;
import persistence.Meeting;

public class AppMain {

	static SessionFactory sessionFactoryObj;
	static Session sessionObj;

	private static SessionFactory buildSessionFactory() {
		Configuration configObj = new Configuration();

		configObj.configure("hibernate.cfg.xml");

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

		sessionFactoryObj  = configObj.buildSessionFactory(serviceRegistry);

		return sessionFactoryObj;			

	}

	public static void main(String[] args) {
		System.out.println("Hibernate Code Starting");

		try {
			sessionObj = buildSessionFactory().openSession();
			sessionObj.beginTransaction();

			Department department1 = new Department();

			department1.setName("Finance");

			sessionObj.save(department1);

			Department department2 = new Department();

			department2.setName("IT");

			sessionObj.save(department2);

			Employee e1 = new Employee();

			e1.setFirstName("Sudha_hibernate");
			e1.setLastName("Agarwal_HB");

			e1.setDepartment(department1);

			Employee e2 = new Employee();

			e2.setFirstName("Sudha1_hibernate");
			e2.setLastName("Agarwal1_HB");

			e2.setDepartment(department2);
			
			department1.setEmpList(Arrays.asList(e1));
			
			department2.setEmpList(Arrays.asList(e2));
			
			Meeting meeting1 = new Meeting();
			meeting1.setSubject("sales meeting");
			meeting1.setMeetingDate(new Date(0));
			
			Meeting meeting2 = new Meeting();
			meeting2.setSubject("AGM");
			meeting2.setMeetingDate(new Date(0));
			
			
			//sessionObj.save(meeting2);
			//sessionObj.save(meeting1);
			
			e1.getMeetings().add(meeting1);
			e1.getMeetings().add(meeting2);
			
			e2.getMeetings().add(meeting2);
			
			sessionObj.save(e2);
			sessionObj.save(e1);
			
			System.out.println("Records saved successfully");
			
			
			sessionObj.getTransaction().commit();

		}
		catch(Exception sqlEx) {
			if(sessionObj.getTransaction() != null) {
				sessionObj.getTransaction().rollback();
			}
			sqlEx.printStackTrace();
		}
		
		finally {
			if(sessionObj !=null) {
				sessionObj.close();
			}
		}

	}

}
