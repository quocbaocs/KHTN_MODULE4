package businessLogics;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class CSDL2 {
	private static DriverManagerDataSource dataSource;

	public static DriverManagerDataSource getDataSource() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/minishop?useUnicode=true&characterEncoding=utf-8");
		dataSource.setUsername("root");
		dataSource.setPassword("");

		return dataSource;
	}
//
//	public static void main(String[] args) {
//		JdbcTemplate jd = getJdbc();
//		if (jd != null) {
//			System.out.println("ket noi thanh cong");
//		} else {
//			System.out.println("Ket noi that bai");
//		}
//	}

}
