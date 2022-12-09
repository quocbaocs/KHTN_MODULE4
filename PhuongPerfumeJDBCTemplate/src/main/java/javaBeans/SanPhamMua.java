package javaBeans;

public class SanPhamMua extends SanPham{

	private static final long serialVersionUID = 1L;
	
	private int soLuongMua;
	
	public SanPhamMua() {
		
	}

	public int getSoLuongMua() {
		return soLuongMua;
	}
	public double thanhTien() {
		return soLuongMua*getDonGiaKM();
	}

	public void setSoLuongMua(int soLuongMua) {
		this.soLuongMua = soLuongMua;
	}
	
	
}
