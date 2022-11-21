package businessLogics;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class CSDL2 {
	private static JdbcTemplate jdbc;

	public static JdbcTemplate getJdbc() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/minishop?useUnicode=true&characterEncoding=utf-8");
		ds.setUsername("root");
		ds.setPassword("");
		jdbc = new JdbcTemplate(ds);
		return jdbc;
	}
	public static void main(String[] args) {
		JdbcTemplate jd = getJdbc();
		if(jd!=null) {
			System.out.println("ket noi thanh cong");
		}else{
			System.out.println("Ket noi that bai");
		}
	}

}
