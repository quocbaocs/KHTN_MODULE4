package controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import businessLogics.CartRepository;
import businessLogics.CategoryBL;
import javaBeans.Cart;

@Controller
@RequestMapping("/cart")
public class CartController {
	CartRepository repository = new CartRepository();

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(Model model, Cart obj, HttpServletRequest request, HttpServletResponse response) {
//		System.out.println(IdGenerator.RandGeneratedStr(11));
		String id = null;
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals("cart")) {
				id = cookie.getValue();
			}
		}
		if (id == null) {
			id = IdGenerator.RandGeneratedStr(32);
			System.out.println("id cart : "+id);
			Cookie cookie = new Cookie("cart", id);
			cookie.setPath(request.getServletContext().getContextPath());
			System.out.println(request.getServletContext().getContextPath());
			cookie.setMaxAge(30 * 24 * 3600);
			response.addCookie(cookie);
		}
		Integer productid = Integer.parseInt(request.getParameter("productId"));
		String quantity = request.getParameter("quantity");
		obj.setId(id);
		obj.setProductId(productid);
		obj.setQuantity(Short.parseShort(quantity));
		repository.add(obj);
//		
		return "redirect:/cart/index";
	}

	@RequestMapping("/index")
	public String index(Model model, @CookieValue("cart") String id) {
		System.out.println(id);
		model.addAttribute("title", "Your Cart");
		model.addAttribute("list", repository.getCarts(id));
		model.addAttribute("children", CategoryBL.getChildren());
		model.addAttribute("parents", CategoryBL.getParrents());
		return "shopingcart";
	}

}
