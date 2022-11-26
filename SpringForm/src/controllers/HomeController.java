package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import businessLogics.CategoryBL;
import businessLogics.ProductBL;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("children", CategoryBL.getChildren());
		model.addAttribute("parents", CategoryBL.getParrents());
		model.addAttribute("products", ProductBL.getProducts());
		return "chao";
	}
}
