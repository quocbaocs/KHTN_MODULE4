package businessLogics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javaBeans.Loai;

public class LoaiBL {
	private static final DriverManagerDataSource ds = CSDL.getDataSource();

	public static List<Loai> docTatCa() {
		String sql = "select * from Loai";

		JdbcTemplate jdbc = new JdbcTemplate(ds);
		return jdbc.query(sql, new RowMapper<Loai>() {

			@Override
			public Loai mapRow(ResultSet rs, int numRow) throws SQLException {
				Loai l = new Loai();
				l.setId(rs.getInt("id"));
				l.setTenLoai(rs.getString("tenloai"));
				return l;
			}

		});
	}

	public static void main(String[] args) {
		docTatCa().forEach(s -> System.out.println(s.getTenLoai()));
	}

}
