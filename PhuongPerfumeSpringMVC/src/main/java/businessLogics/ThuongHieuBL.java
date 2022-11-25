package businessLogics;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javaBeans.ThuongHieu;

public class ThuongHieuBL {

	private static final SessionFactory factory = CSDL.getSessionfactory();

	public static List<ThuongHieu> docTatCa() {

		String sql = "select th from ThuongHieu th";
		try (Session session = factory.openSession()) {
			return session.createQuery(sql, ThuongHieu.class).list();
		} catch (Exception e) {
			return null;
		}

	}

	public static void main(String[] args) {
		List<ThuongHieu> ds = docTatCa();
		ds.forEach(s -> System.out.println(s.getTenthuonghieu()));
	}
}
