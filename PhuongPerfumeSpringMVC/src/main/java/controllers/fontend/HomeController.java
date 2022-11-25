package controllers.fontend;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import businessLogics.LoaiBL;
import businessLogics.QuangCaoBL;
import businessLogics.SanPhamBL;
import businessLogics.ThuongHieuBL;

@Controller
public class HomeController {

	
	@RequestMapping("/")
	public String homePage(HttpServletRequest request) {
		
		return "trang-chu";
	}
	
	@RequestMapping("ListSanPhamMoi")
	public String ListSanPhamMoi(Model model) {
		model.addAttribute("listSanPhamMoi", SanPhamBL.sanPhamMoi(10));
		return "san-pham-moi";
	}
	
	@RequestMapping("ListThuongHieu")
	public String ListThuongHieu(Model model) {
		model.addAttribute("dsThuongHieu", ThuongHieuBL.docTatCa());
		return "thuong-hieu";
	}

	@RequestMapping("BanChayYeuThich")
	public String SanPhamBanChayYeuThich(Model model) {
		
		model.addAttribute("listBanChay", SanPhamBL.banChayNhat(3));
		model.addAttribute("listGiamGia", SanPhamBL.giamGiaNhieu(3));
		return "ban-chay-yeu-thich";
	}
	
	@RequestMapping("ListLoai")
	public String danhSachLoai(Model model) {
		model.addAttribute("dsLoai", LoaiBL.docTatCa());
		return "cuoi-trang";
	}
	
	@RequestMapping("ListQuangCao")
	public String listQuangCao(Model model) {
		
		model.addAttribute("dsqc", QuangCaoBL.docTatCa());
		
		return "quang-cao";
	}

}
