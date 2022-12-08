package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import businessLogics.CategoryBL;
import businessLogics.ProductBL;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String home(Model model) {
		return "home";
	}

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
}
