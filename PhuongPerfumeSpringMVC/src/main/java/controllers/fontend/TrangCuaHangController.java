package controllers.fontend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import businessLogics.SanPhamBL;

@Controller
public class TrangCuaHangController {
	
	@RequestMapping("trang-chu")
	public String SanPhamTrang(@RequestParam(name = "trang", required = false) Integer trang, Model model) {
		if(trang == null) {
			trang = 1;
		}
		model.addAttribute("listSanPhamTrang", SanPhamBL.sanPhamTrang(trang, 12));
		model.addAttribute("tongSoTrang", SanPhamBL.tongSoTrang(12));
		return "trang-cua-hang";
	}

}
