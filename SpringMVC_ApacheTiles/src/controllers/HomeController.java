package controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String home() {

		return "home"; // viewResolver: prefix + viewName + suffix = "/WEB-INF/views/home.jsp
	}

	@RequestMapping("/setCookie")
	@ResponseBody
	public String setCookie(HttpServletResponse response) {
		Cookie ck1 = new Cookie("ten", "Tran_Vi_Tinh");
		Cookie ck2 = new Cookie("lop", "Lap_trinh_java");
		response.addCookie(ck1);
		response.addCookie(ck2);
		return "Da thiet lap cookie";
	}

	@RequestMapping("/getCookie")
	@ResponseBody
	public String setCookie(HttpServletRequest request) {
		Cookie[] mck = request.getCookies();

		String ten = "";
		for (Cookie ck : mck)
			if (ck.getName().equals("ten"))
				ten = ck.getValue();

		return "Lay cookie co ten la: " + ten;
	}
	
	@RequestMapping("/getCookie2")
	@ResponseBody
	public String setCookie(@CookieValue(name = "lop") String lop) {


		return "Lay cookie co ten la: " + lop;
	}
}
