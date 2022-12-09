package businessLogics;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javaBeans.NguoiDung;

public class NguoiDungBL {

	private static final DriverManagerDataSource ds = CSDL.getDataSource();

	public static NguoiDung docTheoEmailPassword(String email, String password) {

		String sql = "select * from NguoiDung where email=? AND password=?";
		JdbcTemplate jdbc = new JdbcTemplate(ds);
		try {
			return jdbc.queryForObject(sql, new RowMapper<NguoiDung>() {

				@Override
				public NguoiDung mapRow(ResultSet rs, int arg1) throws SQLException {
					NguoiDung nd = new NguoiDung();
					nd.setId(rs.getInt("id"));
					nd.setEmail(rs.getString("email"));
					nd.setPassword(rs.getString("password"));
					nd.setHoTen(rs.getString("hoten"));
					nd.setDiaChi(rs.getString("diachi"));
					nd.setDtdd(rs.getString("dtdd"));
					return nd;
				}

			}, email, password);
		} catch (Exception e) {
			return null;
		}

	}

	public static void main(String[] args) {
		NguoiDung nd = docTheoEmailPassword("miendongthao@gmail.com", "12356789");

		if (nd != null) {
			System.out.println(nd.getHoTen());
		} else {
			System.out.println("Email or Password sai");
		}
	}

}
