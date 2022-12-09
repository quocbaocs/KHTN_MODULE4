package controllers.fontend;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import businessLogics.NguoiDungBL;
import javaBeans.NguoiDung;

@Controller

public class LoginController {

	@RequestMapping(path = "/login", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String dangNhap(HttpServletRequest request, @RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password) {
		HttpSession session = request.getSession();
		NguoiDung nd = NguoiDungBL.docTheoEmailPassword(email, password);
		if (nd != null) {
			session.setAttribute("user", NguoiDungBL.docTheoEmailPassword(email, password));
		}
		return nd.getHoTen();

	}

	@RequestMapping(path = "/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		return "redirect:/";
	}

}
