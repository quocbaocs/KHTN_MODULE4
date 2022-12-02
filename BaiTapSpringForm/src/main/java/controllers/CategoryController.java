package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import businessLogics.CategoryBL;
import javaBeans.Category;

@Controller
@RequestMapping("/category")
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
	
	@RequestMapping(path = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("children", CategoryBL.getChildren());
		model.addAttribute("parents", CategoryBL.getParrents());
		
		return "index";
	}
}
