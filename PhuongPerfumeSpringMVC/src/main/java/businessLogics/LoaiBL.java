package businessLogics;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javaBeans.Loai;

public class LoaiBL {
	private static final SessionFactory factory = CSDL.getSessionfactory();

	public static List<Loai> docTatCa() {
		String sql = "select l from Loai l";
		try (Session session = factory.openSession()) {
			return session.createQuery(sql, Loai.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void main(String[] args) {
		docTatCa().forEach(s->System.out.println(s.getTenloai()));
	}

}
