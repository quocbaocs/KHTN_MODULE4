package businessLogics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javaBeans.Category;

public class CategoryBL {
	private static DriverManagerDataSource ds = CSDL2.getDataSource();

	public static List<Category> getParrents() {
		String sql = "select * from category where parentid is null";
		JdbcTemplate jdbc = new JdbcTemplate(ds);
//		try {
//			return jdbc.query(sql, new RowMapper<Category>() {
//				@Override
//				public Category mapRow(ResultSet rs, int numRow) throws SQLException {
//					Category cate = new Category(rs.getInt("categoryid"), rs.getString("categoryname"),
//							rs.getInt("parentId"));
//					return cate;
//				}
//			});
//
//		} catch (Exception e) {
//			return null;
//		}
		return jdbc.query(sql, new AnhXaDong());
	}

	public static List<Category> getChildren() {
		String sql = "select * from category where parentid is not null";
		JdbcTemplate jdbc = new JdbcTemplate(ds);
//		try {
//			return jdbc.query(sql, new RowMapper<Category>() {
//				@Override
//				public Category mapRow(ResultSet rs, int numRow) throws SQLException {
//					Category cate = new Category(rs.getInt("categoryid"), rs.getString("categoryname"),
//							rs.getInt("parentId"));
//					return cate;
//				}
//			});
//
//		} catch (Exception e) {
//			return null;
//		}
		return jdbc.query(sql, new AnhXaDong());
	}

	private static class AnhXaDong implements RowMapper<Category> {

		@Override
		public Category mapRow(ResultSet rs, int numRow) throws SQLException {
			return new Category(rs.getInt("categoryid"), rs.getString("categoryname"), rs.getInt("parentId"));

		}

	}

	public static int them(Category c) {
		JdbcTemplate jdbc = new JdbcTemplate(ds);
		String sql = "insert into category(categoryname, parentid) values(?,?)";
		return jdbc.update(sql, c.getCategoryName(), c.getParentId());
	}

	public static void main(String[] args) {
		CategoryBL.getChildren().forEach(s->System.out.println(s.getCategoryName()));
	}

}
