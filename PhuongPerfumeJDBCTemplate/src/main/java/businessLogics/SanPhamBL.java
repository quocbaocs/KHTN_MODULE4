
package businessLogics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javaBeans.SanPham;

/**
 *
 * @author hv
 */
public class SanPhamBL {

	private static final DriverManagerDataSource ds = CSDL.getDataSource();

	public static List<SanPham> docTatCa() {

		String sql = "select * from SanPham";

		JdbcTemplate jdbc = new JdbcTemplate(ds);
		return jdbc.query(sql, new SanPhamMapper());
	}

	public static SanPham docTheoID(int idSanPham) {
		JdbcTemplate jdbc = new JdbcTemplate(ds);
		String sql = "select * from SanPham where id=?";
		return jdbc.queryForObject(sql, new SanPhamMapper(), idSanPham);

	}

	public static List<SanPham> docTheoLoai(int idLoai) {
		String sql = "select * from sanpham where id_loai = " + idLoai;
		JdbcTemplate jdbc = new JdbcTemplate(ds);
		return jdbc.query(sql, new SanPhamMapper());

	}

	public static List<SanPham> docTheoThuongHieu(int idThuongHieu) {
		String sql = "select * from sanpham where id_thuonghieu = " + idThuongHieu;
		JdbcTemplate jdbc = new JdbcTemplate(ds);
		return jdbc.query(sql, new SanPhamMapper());

	}

	public static SanPham docTheoTen(String tenSanPham) {
		String sql = "select * from SanPham where tensanpham=?";
		JdbcTemplate jdbc = new JdbcTemplate(ds);
		return jdbc.queryForObject(sql, new SanPhamMapper(), tenSanPham);
	}

	public static List<SanPham> timTheoTen(String tenSanPham) {
		String sql = "select * from sanpham where tensanpham like '%" + tenSanPham + "%'";
		JdbcTemplate jdbc = new JdbcTemplate(ds);
		return jdbc.query(sql, new SanPhamMapper());

	}

	public static List<SanPham> sanPhamMoi(int top) {
		String sql = "select * from sanpham order by ngaytao desc limit 0," + top;
		JdbcTemplate jdbc = new JdbcTemplate(ds);
		return jdbc.query(sql, new SanPhamMapper());

	}

	public static List<SanPham> banChayNhat(int top) {
		String sql = "select s.*,sum(c.soluong) as tslb from sanpham s inner join chitietdonhang c "
				+ "on c.id_sanpham = s.id group by 1 order by tslb desc limit 0," + top;
		JdbcTemplate jdbc = new JdbcTemplate(ds);
		return jdbc.query(sql, new SanPhamMapper());

	}

	public static List<SanPham> giamGiaNhieu(int top) {
		String sql = "select s.*, s.dongia-s.dongiaKM as giamGia from sanpham s order by giamGia desc limit 0," + top;
		JdbcTemplate jdbc = new JdbcTemplate(ds);
		return jdbc.query(sql, new SanPhamMapper());

	}

	public static int tongSoTrang(int soDongTrang) {
		int tongSoDong, tongSoTrang;

		tongSoDong = docTatCa().size();
		tongSoTrang = tongSoDong / soDongTrang + (tongSoDong % soDongTrang == 0 ? 0 : 1);
		return tongSoTrang;
	}

	public static List<SanPham> sanPhamTrang(int trang, int soDongTrang) {
		int viTriDau = (trang == 1 ? 0 : (trang - 1) * soDongTrang);
		String sql = "select * from sanpham limit " + viTriDau + "," + soDongTrang;
		JdbcTemplate jdbc = new JdbcTemplate(ds);
		return jdbc.query(sql, new SanPhamMapper());

	}

	public static void main(String[] args) {
		System.out.println(docTheoTen("CHANEL CHANCE EAU VIVE EDT").getDonGia());
		// System.out.println(docTheoID(1).getTenSanPham());
		// timTheoTen("Lancome").forEach(s -> System.out.println(s.getId()));
		// docTatCa().forEach(s->System.out.println(s.getId()));
	}

}

class SanPhamMapper implements RowMapper<SanPham> {

	@Override
	public SanPham mapRow(ResultSet rs, int numRow) throws SQLException {
		SanPham sp = new SanPham();
		sp.setId(rs.getInt("id"));
		sp.setTenSanPham(rs.getString("tensanpham"));
		sp.setMoTa(rs.getString("mota"));
		sp.setHinhAnh(rs.getString("hinhanh"));
		sp.setDonGia(rs.getDouble("dongia"));
		sp.setDonGiaKM(rs.getDouble("dongiaKM"));
		sp.setSoLuong(rs.getInt("soluong"));
		sp.setNgayTao(rs.getDate("ngaytao"));
		sp.setHienThi(rs.getInt("hienthi"));
		sp.setId_loai(rs.getInt("id_loai"));
		sp.setId_thuongHieu(rs.getInt("id_thuonghieu"));
		return sp;
	}

}
