package businessLogics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javaBeans.LoaiSua;

public class LoaiSuaBL {
	public static List<LoaiSua> docTatCa() {
		List<LoaiSua> dsls = new ArrayList<>();
		try (Connection ketNoi = CSDL.getKetNoi()) {
			Statement stm = ketNoi.createStatement();
			ResultSet rs = stm.executeQuery("select * from loai_sua");
			while (rs.next()) {
				LoaiSua ls = new LoaiSua();
				ls.setMaLoai(rs.getString("ma_loai_sua"));
				ls.setTenLoai(rs.getString("ten_loai"));
				dsls.add(ls);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsls;
	}

	public static LoaiSua docTheoMaLoai(String maLoai) {
		LoaiSua ls = null;
		try (Connection ketNoi = CSDL.getKetNoi()) {
			Statement stm = ketNoi.createStatement();
			ResultSet rs = stm.executeQuery("select * from loai_sua where ma_loai_sua='" + maLoai + "'");
			if (rs.next()) {
				ls = new LoaiSua();
				ls.setMaLoai(rs.getString("ma_loai_sua"));
				ls.setTenLoai(rs.getString("ten_loai"));

			}
			return ls;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static int them(LoaiSua ls) {
		String sql = "insert into loai_sua(ma_loai_sua, ten_loai) values (?,?)";
		try (Connection ketNoi = CSDL.getKetNoi()) {
			PreparedStatement pst = ketNoi.prepareStatement(sql);
			pst.setString(1, ls.getMaLoai());
			pst.setString(2, ls.getTenLoai());
			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static LoaiSua tim(String maLoai) {
		LoaiSua ls = null;
		String sql = "select * from loai_sua where ma_loai_sua=?";
		try (Connection ketNoi = CSDL.getKetNoi()) {
			PreparedStatement pst = ketNoi.prepareStatement(sql);
			pst.setString(1, maLoai);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				ls = new LoaiSua();
				ls.setMaLoai(rs.getString("ma_loai_sua"));
				ls.setTenLoai(rs.getString("ten_loai"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ls;
	}

	public static int sua(LoaiSua ls) {
		String sql = "update loai_sua set ten_loai = ? where ma_loai_sua=?";
		try (Connection ketNoi = CSDL.getKetNoi()) {
			PreparedStatement pst = ketNoi.prepareStatement(sql);
			pst.setString(1, ls.getTenLoai());
			pst.setString(2, ls.getMaLoai());
			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int xoa(String maLoai) {
		String sql = "delete from loai_sua where ma_loai_sua=?";
		try (Connection ketNoi = CSDL.getKetNoi()) {
			PreparedStatement pst = ketNoi.prepareStatement(sql);
			pst.setString(1, maLoai);
			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

//	public static int them2() {
//		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
//		String sql = "inser into loai_sua(ma_loai_sua, ten_loai) values(?,?)";
//		int stm = 0;
//		DefaultTransactionDefinition td = new DefaultTransactionDefinition();
//		JdbcTransactionManager tm = new JdbcTransactionManager();
//		TransactionStatus ts = tm.getTransaction(td);
//		try {
//			stm += jdbc.update(sql, "AA", "Sua AA");
//			stm += jdbc.update(sql, "BB", "Sua BB");
//			stm += jdbc.update(sql, "CC", "Sua CC");
//			tm.commit(ts);
//		} catch (Exception e) {
//			stm = 0;
//			tm.rollback(ts);
//		}
//		return stm;
//	}

	public static void main(String[] args) {
		System.out.println(docTheoMaLoai("SD").getTenLoai());
	}

}
