package businessLogics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javaBeans.ThuongHieu;

public class ThuongHieuBL {

	private static final DriverManagerDataSource ds = CSDL.getDataSource();

	public static List<ThuongHieu> docTatCa() {

		String sql = "select * from ThuongHieu";
		JdbcTemplate jdbc = new JdbcTemplate(ds);
		return jdbc.query(sql, new RowMapper<ThuongHieu>() {

			@Override
			public ThuongHieu mapRow(ResultSet rs, int numRow) throws SQLException {
				ThuongHieu th = new ThuongHieu();
				th.setId(rs.getInt("id"));
				th.setTenThuongHieu(rs.getString("tenthuonghieu"));
				th.setHinhAnh(rs.getString("hinhanh"));
			
				return th;
			}
			
		});
		

	}

	public static void main(String[] args) {
		List<ThuongHieu> ds = docTatCa();
		ds.forEach(s -> System.out.println(s.getTenThuongHieu()));
	}
}
