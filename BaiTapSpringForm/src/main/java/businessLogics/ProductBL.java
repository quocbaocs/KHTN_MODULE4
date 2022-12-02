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

	public static List<Product> getProducts() {
		JdbcTemplate jdbc = new JdbcTemplate(ds);
		String sql = "select * from product";
		return jdbc.query(sql, new RowMapper<Product>() {
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
		});
	}

	public static int tongSoTrang(int soDongTrang) {
		int tongSoDong, tongSoTrang;
		String sql = "select COUNT(*) from product";
		JdbcTemplate jdbc = new JdbcTemplate(ds);
		tongSoDong = jdbc.queryForObject(sql, Integer.class);
		tongSoTrang = tongSoDong / soDongTrang + (tongSoDong % soDongTrang == 0 ? 0 : 1);
		return tongSoTrang;
	}

	public static List<Product> sanPhamTrang(int trang, int soDongTrang) {
		int viTriDau = (trang == 1 ? 0 : (trang - 1) * soDongTrang);
		JdbcTemplate jdbc = new JdbcTemplate(ds);
		String sql = "select * from product LIMIT " + viTriDau + "," + soDongTrang;
		return jdbc.query(sql, new RowMapper<Product>() {

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

		});

	}

	public static void main(String[] args) {
		search("C#").forEach(s->System.out.println(s.getTitle()));
	}

	public static Product getProduct(Integer id) {
		JdbcTemplate jdbc = new JdbcTemplate(ds);
		String sql = "select * from product where productId=?";
		return jdbc.queryForObject(sql, new RowMapper<Product>() {
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
		}, id);

	}

	public static List<Product> search(String keyword) {
		JdbcTemplate jdbc = new JdbcTemplate(ds);
		String sql = "select * from product where title LIKE ?";
		return jdbc.query(sql, new RowMapper<Product>() {
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
		}, "%" + keyword + "%");
	}

}
