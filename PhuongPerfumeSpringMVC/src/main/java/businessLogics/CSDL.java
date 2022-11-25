package businessLogics;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//Trả về sessionFactory

public class CSDL {
	private static final SessionFactory factory;
	static {
		factory = new Configuration().configure().buildSessionFactory();
	}

	public static SessionFactory getSessionfactory() {
		return factory;
	}

}
