package businessLogics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javaBeans.NguoiDung;

public class NguoiDungBL {

	private static final SessionFactory factory = CSDL.getSessionfactory();

	public static NguoiDung docTheoEmailPassword(String email, String password) {

		String sql = "select nd from NguoiDung nd where nd.email=:email AND password=:password";
		try (Session sessison = factory.openSession()) {
			return sessison.createQuery(sql, NguoiDung.class).setParameter("email", email)
					.setParameter("password", password).list().get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static void main(String[] args) {
		NguoiDung nd = docTheoEmailPassword("miendongthao@gmail.com", "123456789");

		if (nd != null) {
			System.out.println(nd.getHoten());
		} else {
			System.out.println("Email or Password sai");
		}
	}

}
