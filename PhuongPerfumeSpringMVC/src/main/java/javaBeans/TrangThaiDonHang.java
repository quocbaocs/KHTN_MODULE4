package javaBeans;
// Generated Nov 23, 2022 6:27:45 PM by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Trangthaidonhang generated by hbm2java
 */
@Entity
@Table(name = "trangthaidonhang", catalog = "phuong_perfume")
public class TrangThaiDonHang implements java.io.Serializable {

	private Integer id;
	private String tentrangthai;
	private Set<DonHang> donhangs = new HashSet<DonHang>(0);

	public TrangThaiDonHang() {
	}

	public TrangThaiDonHang(String tentrangthai) {
		this.tentrangthai = tentrangthai;
	}

	public TrangThaiDonHang(String tentrangthai, Set<DonHang> donhangs) {
		this.tentrangthai = tentrangthai;
		this.donhangs = donhangs;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "tentrangthai", nullable = false, length = 100)
	public String getTentrangthai() {
		return this.tentrangthai;
	}

	public void setTentrangthai(String tentrangthai) {
		this.tentrangthai = tentrangthai;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trangthaidonhang")
	public Set<DonHang> getDonhangs() {
		return this.donhangs;
	}

	public void setDonhangs(Set<DonHang> donhangs) {
		this.donhangs = donhangs;
	}

}