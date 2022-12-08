package interceptors;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import businessLogics.LoaiSuaBL;
import javaBeans.LoaiSua;

public class LoaiSuaInterceptor implements HandlerInterceptor {
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		List<LoaiSua> dsls = LoaiSuaBL.docTatCa();
		modelAndView.addObject("dsls", dsls);
	}
}
