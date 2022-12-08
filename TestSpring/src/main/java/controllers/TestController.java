package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping(path="/home")
	public String hello(Model model) {
		model.addAttribute("a", "hello");
		return "hello";
	}
}
