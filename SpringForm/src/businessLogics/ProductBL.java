package businessLogics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javaBeans.Product;

public class ProductBL {
	private static DriverManagerDataSource ds = CSDL2.getDataSource();

	public static final int SO_DONG_TRANG = 6;

	private static class AnhXaDong implements RowMapper<Product> {

		@Override
		public Product mapRow(ResultSet rs, int numRow) throws SQLException {
			Product p = new Product();
			p.setProductId(rs.getInt("productid"));
			p.setCategoryId(rs.getInt("categoryid"));
			p.setPublisherId(rs.getInt("publisherid"));
			p.setIsbn(rs.getString("isbn"));
			p.setTitle(rs.getString("title"));
			p.setPage(rs.getInt("pages"));
			p.setYear(rs.getInt("year"));
			p.setWeight(rs.getString("weight"));
			p.setSize(rs.getString("size"));
			p.setDescription(rs.getString("description"));
			p.setContent(rs.getString("content"));
			p.setImageUrl(rs.getString("imageurl"));
			p.setPrice(rs.getInt("price"));
			return p;
		}

	}

	public static List<Product> getProducts() {
		JdbcTemplate jdbc = new JdbcTemplate(ds);
		String sql = "select * from product";
		return jdbc.query(sql, new AnhXaDong());
	}

	public static int tongSoDong() {
		JdbcTemplate jdbc = new JdbcTemplate(ds);
		String sql = "select COUNT(*) as tsd from product";
		// return jdbc.queryForObject(sql, Integer.class);
		return jdbc.queryForObject(sql, new RowMapper<Integer>() {
			@Override
			public Integer mapRow(ResultSet rs, int numRow) throws SQLException {

				return rs.getInt("tsd");
			}
		});

	}

	public static List<Product> sanPhamTheoTrang(int trang) {
		int vitri = (trang - 1) * SO_DONG_TRANG;
		String sql = "select * from Product limit " + vitri + "," + SO_DONG_TRANG;
		JdbcTemplate jdbc = new JdbcTemplate(ds);
		return jdbc.query(sql, new AnhXaDong());
	}

	public static List<Product> getProductsByCategory(int categoryId) {
		String sql = "select * from Product where categoryId=" + categoryId;
		JdbcTemplate jdbc = new JdbcTemplate(ds);
		return jdbc.query(sql, new AnhXaDong());
	}

	public static void main(String[] args) {
		getProductsByCategory(8).forEach(S -> System.out.println(S.getTitle()));
	}

}
