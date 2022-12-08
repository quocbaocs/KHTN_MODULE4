package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import businessLogics.CategoryBL;
import businessLogics.ProductBL;
import javaBeans.Category;

@Controller
public class CategoryController {

	@RequestMapping(path = "/add-category", method = RequestMethod.GET)
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		model.addAttribute("parents", CategoryBL.getParrents());

		return "addCategory";
	}

	@RequestMapping(path = "/add-category", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute Category category, Model model) {
		CategoryBL.them(category);
		model.addAttribute("parents", CategoryBL.getParrents());

		return "addCategory";
	}

	/**
	 * 
	 */
//	@RequestMapping(path = "/index", method = RequestMethod.GET)
//	public String index(Model model, @RequestParam(name = "trang", defaultValue = "1", required = false) int trang) {
//		model.addAttribute("children", CategoryBL.getChildren());
//		model.addAttribute("parents", CategoryBL.getParrents());
//
//		model.addAttribute("products", ProductBL.sanPhamTheoTrang(trang));
//
//		int tsd = ProductBL.tongSoDong();
//		int tongSoTrang = tsd / ProductBL.SO_DONG_TRANG + (tsd % ProductBL.SO_DONG_TRANG != 0 ? 1 : 0);
//
//		model.addAttribute("tongSoTrang", tongSoTrang);
//		return "index";
//	}
//	@RequestMapping(path = "/index", method = RequestMethod.GET)
//	public String index(Model model) {
//		model.addAttribute("children", CategoryBL.getChildren());
//		model.addAttribute("parents", CategoryBL.getParrents());
//
//		model.addAttribute("products", ProductBL.sanPhamTheoTrang(1));
//
//		int tsd = ProductBL.tongSoDong();
//		int tongSoTrang = tsd / ProductBL.SO_DONG_TRANG + (tsd % ProductBL.SO_DONG_TRANG != 0 ? 1 : 0);
//
//		model.addAttribute("tongSoTrang", tongSoTrang);
//		return "index";
//	}

	@RequestMapping(path = { "/index", "/index/{trang}" }, method = RequestMethod.GET)
	public String index(Model model, @PathVariable(name = "trang", required = false) Integer trang) {
		model.addAttribute("children", CategoryBL.getChildren());
		model.addAttribute("parents", CategoryBL.getParrents());
		if (trang == null) {
			trang = 1;
		}
		model.addAttribute("products", ProductBL.sanPhamTheoTrang(trang));

		int tsd = ProductBL.tongSoDong();
		int tongSoTrang = tsd / ProductBL.SO_DONG_TRANG + (tsd % ProductBL.SO_DONG_TRANG != 0 ? 1 : 0);

		model.addAttribute("tongSoTrang", tongSoTrang);
		return "index";
	}

	@RequestMapping(path = "/index/category/{categoryId}", method = RequestMethod.GET)
	public String indexCategory(Model model, @PathVariable(name = "categoryId", required = false) int categoryId) {
		System.out.println("dang o day");
		model.addAttribute("children", CategoryBL.getChildren());
		model.addAttribute("parents", CategoryBL.getParrents());

		model.addAttribute("products", ProductBL.getProductsByCategory(categoryId));
		int tsd = ProductBL.tongSoDong();
		int tongSoTrang = tsd / ProductBL.SO_DONG_TRANG + (tsd % ProductBL.SO_DONG_TRANG != 0 ? 1 : 0);

		model.addAttribute("tongSoTrang", tongSoTrang);
		return "index";
	}

}
