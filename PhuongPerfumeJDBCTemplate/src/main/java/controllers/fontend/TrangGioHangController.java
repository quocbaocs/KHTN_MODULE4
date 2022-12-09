package controllers.fontend;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import businessLogics.SanPhamBL;
import javaBeans.GioHang;
import javaBeans.SanPham;

@Controller
@SessionAttributes("cart")
public class TrangGioHangController {

//	@RequestMapping(path = "them-vao-gio")
//	@ResponseBody
//	public String themGioHang(@RequestParam("idsp") Integer id, @RequestParam("slm") Integer quantity,
//			HttpServletRequest request, Model model) {
//		HttpSession session = request.getSession();
//		GioHang cart = (GioHang) session.getAttribute("cart");
//		SanPham p = SanPhamBL.docTheoID(id);
//		if (cart == null) {
//			cart = new GioHang();
//
//		}
//		cart.addCart(p, quantity);
//		session.setAttribute("cart", cart);
//		// System.out.println(quantity);
//		return cart.getTongTien() + ";" + cart.getSize();
//
//	}
//
//	@RequestMapping("xoa-item-gio")
//	@ResponseBody
//	public String xoaItemGioHang(@RequestParam(name = "idsp") Integer id, HttpServletRequest request, Model model) {
//		HttpSession session = request.getSession();
//		GioHang cart = (GioHang) session.getAttribute("cart");
//		SanPham sp = SanPhamBL.docTheoID(id);
//		cart.deleteItemCart(sp);
//		model.addAttribute("cart", cart);
//		return cart.getTongTien() + ";" + cart.getSize();
//	}
//
//	@RequestMapping("cap-nhat-gio-hang")
//	@ResponseBody
//	public String capNhatGioHang(@RequestParam(name = "idsp") Integer id, @RequestParam(name = "slm") Integer qtNew,
//			HttpServletRequest request, Model model) {
//		HttpSession session = request.getSession();
//		GioHang cart = (GioHang) session.getAttribute("cart");
//		SanPham sp = SanPhamBL.docTheoID(id);
//		cart.updateQuantity(sp, qtNew);
//		model.addAttribute("cart", cart);
//		return cart.getTongTien() + ";" + cart.getSize();
//	}

	@RequestMapping("gio-hang")
	public String gioHang(@RequestParam(name = "keyword", required = false) String keyword, Model model) {
		System.out.println(keyword);
		if(keyword!=null) {
			model.addAttribute("dsTim", SanPhamBL.timTheoTen(keyword));
		}
		return "trang-gio-hang";
	}

	/*-------------------------------------*/
	@ModelAttribute("cart")
	public GioHang getGioHang() {
		return new GioHang();
	}

	@RequestMapping(path = "them-vao-gio")
	@ResponseBody
	public String themGioHang(@RequestParam("idsp") Integer id, @RequestParam("slm") Integer quantity,
			HttpServletRequest request, Model model, @ModelAttribute("cart") GioHang cart) {

		SanPham p = SanPhamBL.docTheoID(id);
		if (cart != null) {
			cart.addCart(p, quantity);
			model.addAttribute("cart", cart);
		}else {
			GioHang gioHang = new GioHang();
			gioHang.addCart(p, quantity);
			model.addAttribute("cart", gioHang);
		}
		
		return cart.getTongTien() + ";" + cart.getSize();

	}
	@RequestMapping("xoa-item-gio")
	@ResponseBody
	public String xoaItemGioHang(@RequestParam(name = "idsp") Integer id, Model model, @ModelAttribute("cart") GioHang cart) {
		
		SanPham sp = SanPhamBL.docTheoID(id);
		cart.deleteItemCart(sp);
		model.addAttribute("cart", cart);
		return cart.getTongTien() + ";" + cart.getSize();
	}

	@RequestMapping("cap-nhat-gio-hang")
	@ResponseBody
	public String capNhatGioHang(@RequestParam(name = "idsp") Integer id, @RequestParam(name = "slm") Integer qtNew,
			@ModelAttribute("cart") GioHang cart, Model model) {
		
		SanPham sp = SanPhamBL.docTheoID(id);
		cart.updateQuantity(sp, qtNew);
		model.addAttribute("cart", cart);
		return cart.getTongTien() + ";" + cart.getSize();
	}

}
