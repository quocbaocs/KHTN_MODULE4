package javaBeans;

import java.util.HashMap;
import java.util.Map;

import businessLogics.SanPhamBL;

public class GioHang {
	private Map<SanPham, Integer> cart = new HashMap<SanPham, Integer>();

	public GioHang() {
	}

	public void addCart(SanPham sp, int quantity) {
		if (cart.containsKey(sp)) {
			cart.put(sp, cart.get(sp) + quantity);

		} else {

			cart.put(sp, quantity);
		}
	}

	public double getTongTien() {
		double tien = 0;
		for (Map.Entry<SanPham, Integer> item : cart.entrySet()) {
			tien += item.getValue() * item.getKey().getDongiaKm();

		}
		return tien;
	}

	public void updateQuantity(SanPham sp, int qtNew) {
		if (cart.containsKey(sp)) {
			cart.put(sp, qtNew);
		}
	}

	public void getQuantity(SanPham sp) {
		if (cart.containsKey(sp)) {
			System.out.println("value :" + cart.get(sp));
		}
	}

	public Map<SanPham, Integer> getGioHang() {
		return this.cart;
	}

	public void deleteItemCart(SanPham sp) {
		cart.remove(sp);
	}

	public static void main(String[] args) {
		SanPham sp = SanPhamBL.docTheoID(12);
		GioHang cart = new GioHang();
		cart.addCart(sp, 3);
		cart.addCart(SanPhamBL.docTheoID(1), 5);
		Map<SanPham, Integer> c = cart.getGioHang();
		c.forEach((k, v) -> {
			System.out.println(v);
		});
		System.out.println("so luong : "+cart.getSize());
	}

	public int getSize() {
		return this.cart.size();
	}
}
