package businessLogics;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

//Trả về sessionFactory

public class CSDL {
	
	private static DriverManagerDataSource dataSource;
	
	public static DriverManagerDataSource getDataSource() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/phuong_perfume?useUnicode=true&useCharacterEncoding=UTF-8");
		dataSource.setUsername("root");
		dataSource.setPassword("quocbao@123");

		return dataSource;
	}
	
//	private static final SessionFactory factory;
//	static {
//		factory = new Configuration().configure().buildSessionFactory();
//	}
//
//	public static SessionFactory getSessionfactory() {
//		return factory;
//	}

}
