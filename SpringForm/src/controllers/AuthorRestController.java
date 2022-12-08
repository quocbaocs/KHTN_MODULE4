package controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import businessLogics.AuthorBL;
import javaBeans.Author;

@RestController
public class AuthorRestController {

	@GetMapping(path = "/author-rest")
	public List<Author> authors() {
		return AuthorBL.docTatCa();
	}

	@GetMapping(path = "/author-rest/{id}")
	public Author author(@PathVariable("id") int id) {
		return AuthorBL.docTheoId(id);
	}

	@PostMapping(path = "/add-author-rest")
	public int addAuthor(@RequestBody Author au) {

		return AuthorBL.them(au);
	}

	@PutMapping(path = "/edit-author-rest")
	public int edit(Author au) {
		return AuthorBL.sua(au);
	}

	@DeleteMapping(path = "/del-author-rest/{id}")
	public int delAuthor(@PathVariable(name = "id") int id) {
		return AuthorBL.xoa(id);
	}
}
