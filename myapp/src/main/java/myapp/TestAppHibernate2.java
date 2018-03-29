package myapp;

import javax.persistence.EntityManager;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestAppHibernate2 {

	
	//alternate configuration for session factory, few others ways can be done
	public static void main(String[] args) {
		Configuration configuration = 
				new Configuration()
				.configure("hibernate-alternate-config/hibernate-alternate-config.xml")
				.addAnnotatedClass(Author.class);
		
		SessionFactory factory = configuration.buildSessionFactory();
		EntityManager entityManager = factory.createEntityManager();
		
		
		Author author = entityManager.find(Author.class, new Long(1002));
		System.out.println(author);
		
		
		entityManager.close();
		factory.close();
	}

}
