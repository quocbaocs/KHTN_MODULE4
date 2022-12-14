package javaBeans;
// Generated Nov 23, 2022 6:27:45 PM by Hibernate Tools 4.3.5.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Vaitro generated by hbm2java
 */
@Entity
@Table(name = "vaitro", catalog = "phuong_perfume")
public class VaiTro implements java.io.Serializable {

	private Integer id;
	private String tenvaitro;
	private String mota;
	private Set<NguoiDung> nguoidungs = new HashSet<NguoiDung>(0);

	public VaiTro() {
	}

	public VaiTro(String tenvaitro) {
		this.tenvaitro = tenvaitro;
	}

	public VaiTro(String tenvaitro, String mota, Set<NguoiDung> nguoidungs) {
		this.tenvaitro = tenvaitro;
		this.mota = mota;
		this.nguoidungs = nguoidungs;
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

	@Column(name = "tenvaitro", nullable = false, length = 100)
	public String getTenvaitro() {
		return this.tenvaitro;
	}

	public void setTenvaitro(String tenvaitro) {
		this.tenvaitro = tenvaitro;
	}

	@Column(name = "mota", length = 65535)
	public String getMota() {
		return this.mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vaitro")
	public Set<NguoiDung> getNguoidungs() {
		return this.nguoidungs;
	}

	public void setNguoidungs(Set<NguoiDung> nguoidungs) {
		this.nguoidungs = nguoidungs;
	}

}
