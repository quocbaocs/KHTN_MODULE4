package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import businessLogics.CategoryBL;
import businessLogics.ProductBL;

@Controller
@RequestMapping("/home")
public class HomeController {

	@RequestMapping("")
	public String home(Model model, @RequestParam(name = "trang", required = false) Integer trang) {
		model.addAttribute("children", CategoryBL.getChildren());
		model.addAttribute("parents", CategoryBL.getParrents());
		System.out.println(trang);
		if (trang == null) {
			trang = 1;
		}
		model.addAttribute("products", ProductBL.sanPhamTrang(trang, 8));
		model.addAttribute("tongSoTrang", ProductBL.tongSoTrang(8));

		return "home";
	}

	@RequestMapping("detail")
	public String detail(@RequestParam(name = "id") Integer id, Model model) {
		model.addAttribute("children", CategoryBL.getChildren());
		model.addAttribute("parents", CategoryBL.getParrents());
		model.addAttribute("product", ProductBL.getProduct(id));
		System.out.println("detail page");
		return "detail";
	}
	
	@RequestMapping("/search")
	public String search(@RequestParam("keyword") String keyword, Model model) {
		model.addAttribute("children", CategoryBL.getChildren());
		model.addAttribute("parents", CategoryBL.getParrents());
		model.addAttribute("products", ProductBL.search(keyword));
		return "home";
	}
}
