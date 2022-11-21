package businessLogics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javaBeans.Author;

public class AuthorBL {

	private static JdbcTemplate jdbc = CSDL2.getJdbc();

	public static List<Author> docTatCa() {
		String sql = "select * from author";
		try {
			return jdbc.query(sql, new RowMapper<Author>() {
				@Override
				public Author mapRow(ResultSet rs, int numRow) throws SQLException {
					Author au = new Author();
					au.setId(rs.getInt("authorId"));
					au.setName(rs.getString("authorName"));
					return au;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Author docTheoId(int id) {

		String sql = "select * from author where authorid = ?";
		return jdbc.queryForObject(sql, new RowMapper<Author>() {

			@Override
			public Author mapRow(ResultSet rs, int numRow) throws SQLException {
				Author au = new Author();
				au.setId(rs.getInt("authorId"));
				au.setName(rs.getString("authorName"));
				return au;
			}

		}, id);
	}

	public static int them(Author au) {
		String sql = "insert into author(authorname) values(?)";
		return jdbc.update(sql, au.getName());

	}

	public static int sua(Author au) {
		String sql = "update author set authorname=? where authorid=?";
		return jdbc.update(sql, au.getName(), au.getId());
	}

	public static int xoa(int id) {

		String sql = "delete from author where authorid = ?";
		return jdbc.update(sql, id);
	}

	public static void main(String[] args) {
		// docTatCa().forEach(s -> System.out.println(s.getName()));

		// System.out.println(docTheoId(1).getName());

		// Author au = new Author("thanh thanh");

		// System.out.println(them(au));

		//		Author au = docTheoId(27);
		//		au.setName("new author");
		//		System.out.println(sua(au));
				
		System.out.println(xoa(27));
	}

	public static void xoa(List<Author> list) {
		String sql = "delete from author where authorid = ?";
		list.forEach(item -> jdbc.update(sql, item.getId()));
	
		
		
	}

}
