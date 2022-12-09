package businessLogics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javaBeans.QuangCao;

public class QuangCaoBL {
	private static final DriverManagerDataSource ds = CSDL.getDataSource();

	public static List<QuangCao> docTatCa() {
		String sql = "select * from QuangCao";
		JdbcTemplate jdbc = new JdbcTemplate(ds);
		return jdbc.query(sql, new RowMapper<QuangCao>() {

			@Override
			public QuangCao mapRow(ResultSet rs, int numRow) throws SQLException {
				QuangCao qc = new QuangCao();
				qc.setId(rs.getInt("id"));
				qc.setHinhAnh(rs.getString("hinhanh"));
				qc.setThongDiep(rs.getString("thongdiep"));
				qc.setThongTinChiTiet(rs.getString("thongtinchitiet"));
				qc.setNgayDang(rs.getDate("ngaydang"));
				return qc;
			}
			
		});

	}

	public static void main(String[] args) {
		List<QuangCao> ds = docTatCa();
		for (QuangCao qc : ds) {
			System.out.println(qc.getThongDiep());
		}
	}
}
