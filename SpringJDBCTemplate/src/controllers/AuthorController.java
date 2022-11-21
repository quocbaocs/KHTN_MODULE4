package controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import businessLogics.AuthorBL;
import javaBeans.Author;

@Controller
public class AuthorController {
	@RequestMapping("/authors")
	public String authors(Model model) {
		model.addAttribute("authors", AuthorBL.docTatCa());
		return "authors";
	}

	@RequestMapping("/add-author")
	public String addAuthor() {
		return "add-author";
	}

	@RequestMapping(path = "/add-author", method = RequestMethod.POST)
	public String addAuthor(@RequestParam(name = "name", required = false) String name, Model model) {
		System.out.println(name);
		AuthorBL.them(new Author(name));
		model.addAttribute("authors", AuthorBL.docTatCa());
		return "authors";
	}

	@RequestMapping("/edit-author")
	public String editAuthor(@RequestParam(name = "id", required = false) Integer id, Model model) {
		model.addAttribute("au", AuthorBL.docTheoId(id));
		return "edit-author";
	}

	@RequestMapping(path = "/edit-author", method = RequestMethod.POST)
	public String editAuthor(HttpServletRequest request, Model model) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		AuthorBL.sua(new Author(id, name));
		model.addAttribute("authors", AuthorBL.docTatCa());
		return "authors";
	}

	@RequestMapping("/del-author")
	public String delAuthor(@RequestParam(name = "id", required = false) Integer id, Model model) {
		AuthorBL.xoa(id);
		model.addAttribute("authors", AuthorBL.docTatCa());
		return "authors";
	}
	
	@RequestMapping(path = "/dels")
	public String deleteAuthors(@RequestParam(name = "ids", required = false) List<Author> list, Model model) {
		
		AuthorBL.xoa(list);
		model.addAttribute("authors", AuthorBL.docTatCa());
		
		return "authors";
	}
}
