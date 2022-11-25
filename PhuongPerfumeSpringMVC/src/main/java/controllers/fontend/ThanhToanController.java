package controllers.fontend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import businessLogics.SanPhamBL;

@Controller
public class ThanhToanController {

	@RequestMapping("/thanh-toan")
	public String trangThanhToan(@RequestParam(value  = "keyword", required = false) String keyword, Model model) {
		
		if(keyword!=null) {
			model.addAttribute("dsTim", SanPhamBL.timTheoTen(keyword));
		}
		return "trang-thanh-toan";
	}
}
