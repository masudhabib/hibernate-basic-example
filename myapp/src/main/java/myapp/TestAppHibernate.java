package myapp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestAppHibernate {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Author> authors = session.createQuery("FROM Author WHERE ID>1002", Author.class).list();
		
		System.out.println("\nprinting authors from first list");
		for(Author author : authors){
			System.out.println(author);
		}
		
		System.out.println("\nprinting authors from second list");
		List<Author> authors2 = session.createQuery("FROM Author", Author.class).list();
		for(Author author : authors2){
			System.out.println(author);
		}
		session.close();
	}

}
