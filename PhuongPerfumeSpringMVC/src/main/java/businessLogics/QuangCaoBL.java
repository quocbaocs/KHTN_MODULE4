package businessLogics;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javaBeans.QuangCao;

public class QuangCaoBL {
	private static final SessionFactory factory = CSDL.getSessionfactory();

	public static List<QuangCao> docTatCa() {
		String sql = "select qc from QuangCao qc";
		try (Session session = factory.openSession()) {
			return session.createQuery(sql, QuangCao.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static void main(String[] args) {
		List<QuangCao> ds = docTatCa();
		for (QuangCao qc : ds) {
			System.out.println(qc.getThongdiep());
		}
	}
}
