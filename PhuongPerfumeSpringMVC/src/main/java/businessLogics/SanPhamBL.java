
package businessLogics;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javaBeans.SanPham;

/**
 *
 * @author hv
 */
public class SanPhamBL {

	private static final SessionFactory factory = CSDL.getSessionfactory();

	public static List<SanPham> docTatCa() {

		String sql = "select sp from SanPham sp";
		try (Session session = factory.openSession()) {
			return session.createQuery(sql, SanPham.class).list();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static SanPham docTheoID(int idSanPham) {
		try (Session session = factory.openSession()) {
			return session.get(SanPham.class, idSanPham);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<SanPham> docTheoLoai(int idLoai) {
		String sql = "select sp from SanPham sp left join fetch sp.loai where sp.loai.id =:idLoai";
		try (Session session = factory.openSession()) {
			return session.createQuery(sql, SanPham.class).setParameter("idLoai", idLoai).getResultList();
		} catch (Exception e) {
			return null;
		}

	}

	public static List<SanPham> docTheoThuongHieu(int idThuongHieu) {
		String sql = "select sp from SanPham sp left join fetch sp.thuonghieu where sp.thuonghieu.id =:idThuongHieu";
		try (Session session = factory.openSession()) {
			return session.createQuery(sql, SanPham.class).setParameter("idThuongHieu", idThuongHieu).getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	public static SanPham docTheoTen(String tenSanPham) {
		String sql = "select sp from SanPham sp where sp.tensanpham=:tenSanPham";
		try (Session session = factory.openSession()) {
			return session.createQuery(sql, SanPham.class).setParameter("tenSanPham", tenSanPham).list().get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<SanPham> timTheoTen(String tenSanPham) {
		String sql = "select sp from SanPham sp where sp.tensanpham like :tenSanPham";
		try (Session session = factory.openSession()) {
			return session.createQuery(sql, SanPham.class).setParameter("tenSanPham", "%" + tenSanPham + "%").list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<SanPham> sanPhamMoi(int top) {
		String sql = "select sp from SanPham sp order by sp.ngaytao desc";
		try (Session session = factory.openSession()) {
			return session.createQuery(sql, SanPham.class).setFirstResult(0).setMaxResults(top).list();
		} catch (Exception e) {
			return null;
		}

	}

	public static List<SanPham> banChayNhat(int top) {

		String sql = "select sp, sum(ct.soluong) as tsl  from SanPham sp join sp.chitietdonhangs ct group by sp order by tsl desc";
		List<SanPham> dsSP = new ArrayList<SanPham>();
		try (Session session = factory.openSession()) {

			List<Object> dsObj = session.createQuery(sql).setFirstResult(0).setMaxResults(top).list();
			for (Object obj : dsObj) {
				Object[] mc = (Object[]) obj;
				SanPham s = (SanPham) mc[0];
				dsSP.add(s);
			}
			return dsSP;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static List<SanPham> giamGiaNhieu(int top) {
		String sql = "select sp, sp.dongia-sp.dongiaKm as giamGia from SanPham sp order by giamGia desc";
		List<SanPham> dsSP = new ArrayList<SanPham>();
		try (Session session = factory.openSession()) {
			List<Object> dsObj = session.createQuery(sql).setFirstResult(0).setMaxResults(top).list();
			for (Object obj : dsObj) {
				Object[] mc = (Object[]) obj;
				SanPham s = (SanPham) mc[0];
				dsSP.add(s);
			}
			return dsSP;

		} catch (Exception e) {
			// return null;
			e.printStackTrace();
			return null;
		}

	}

	public static int tongSoTrang(int soDongTrang) {
		int tongSoDong, tongSoTrang;
		String sql = "select sp from SanPham sp";
		try (Session session = factory.openSession()) {
			tongSoDong = session.createQuery(sql, SanPham.class).list().size();
			tongSoTrang = tongSoDong / soDongTrang + (tongSoDong % soDongTrang == 0 ? 0 : 1);
			return tongSoTrang;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	public static List<SanPham> sanPhamTrang(int trang, int soDongTrang) {
		int viTriDau = (trang == 1 ? 0 : (trang - 1) * soDongTrang);
		String sql = "select sp from SanPham sp";
		try (Session session = factory.openSession()) {
			return session.createQuery(sql, SanPham.class).setFirstResult(viTriDau).setMaxResults(soDongTrang)
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static void main(String[] args) {
		// System.out.println(docTheoTen("CHANEL CHANCE EAU VIVE EDT").getDongiaKm());

		timTheoTen("Lancome").forEach(s -> System.out.println(s.getId()));
	}
}
