package controllers.fontend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import businessLogics.SanPhamBL;
import javaBeans.SanPham;

@Controller
public class ChiTietSanPhamController {

	@RequestMapping(value = "/san-pham/{sanpham}/{id}", produces = "text/plain;charset=UTF-8")
	public String chiTietSanPham(@PathVariable("sanpham") String sanpham,
			@RequestParam(name = "keyword", required = false) String keyword, Model model) {
		// System.out.println(sanpham);
		if (keyword != null) {

			model.addAttribute("dsTim", SanPhamBL.timTheoTen(keyword));
			// SanPhamBL.timTheoTen(keyword).forEach(s -> System.out.println(s.getId()));
		}
		SanPham sp = SanPhamBL.docTheoTen(sanpham);
		model.addAttribute("sp", sp);
		model.addAttribute("dsLQ", SanPhamBL.docTheoLoai(sp.getId_loai()));
		//SanPhamBL.docTheoLoai(sp.getLoai().getId()).forEach(s->System.out.println(s.getTensanpham()));
		return "trang-san-pham";
	}

}
