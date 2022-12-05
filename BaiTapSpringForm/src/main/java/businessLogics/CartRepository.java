package businessLogics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import controllers.IdGenerator;
import javaBeans.Cart;

public class CartRepository {

	private DriverManagerDataSource ds = CSDL2.getDataSource();

	public List<Cart> getCarts(String id) {
		JdbcTemplate jdbc = new JdbcTemplate(ds);
		return jdbc.query("CALL GetCarts(?)", new RowMapper<Cart>() {
			@Override
			public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Cart(rs.getString("CartId"), rs.getInt("ProductId"), rs.getString("Title"),
						rs.getString("ImageUrl"), rs.getInt("Price"), rs.getShort("Quantity"));
			}
		}, id);
	}

	public int add(Cart obj) {
		JdbcTemplate jdbc = new JdbcTemplate(ds);
		return jdbc.update("CALL AddCart(?, ?, ?, ?)", obj.getId(), obj.getMemberId(), obj.getProductId(),
				obj.getQuantity());
	}

	public void del(Cart obj) {
		System.out.println(obj.getId());
		System.out.println(obj.getProductId());
		JdbcTemplate jdbc = new JdbcTemplate(ds);
		jdbc.update("CALL DeleteCart(?,?)", obj.getId(), obj.getProductId());
	}

	public static void main(String[] args) {
		CartRepository shop = new CartRepository();
//		String id = IdGenerator.RandGeneratedStr(10);
		Cart obj = new Cart();
		obj.setId("Rlrcok2wW1d7qfPDNWDOPNTNkwjTEUVH");
		obj.setProductId(3);
//		obj.setMemberId(Long.parseLong("524261494281601881"));
//		obj.setProductId(11);
//		obj.setQuantity(Short.parseShort("1"));

		shop.del(obj);

		
		List<Cart> list = null;
		try {
			list = shop.getCarts("Rlrcok2wW1d7qfPDNWDOPNTNkwjTEUVH");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		for (Cart c : list) {
			System.out.println(c.getProductId());
		}

	}

}
