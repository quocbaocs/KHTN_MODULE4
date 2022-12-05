package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import businessLogics.CategoryBL;

public class CategoryInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("children", CategoryBL.getChildren());
		request.setAttribute("parent", CategoryBL.getParrents());
		return true;
	}
}
