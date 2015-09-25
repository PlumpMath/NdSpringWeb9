package com.tatvasoft.interceptor;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class UsermasterInterceptor implements HandlerInterceptor {


	public static Cookie getCookie(HttpServletRequest request, String name) {
		if (request.getCookies() != null) {
			for (Cookie cookie : request.getCookies()) {
				if (cookie.getName().equals(name)) {
					return cookie;
				}
			}
		}

		return null;
	}




	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
					throws Exception {
		System.out.println("completed-handler");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("post-handler");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("pre-handler");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);

		HttpSession sessions = request.getSession();
		String str = (String)sessions.getAttribute("username_s");
		if(request.getRequestURL().toString().contains("login")){
			Cookie cookie = UsermasterInterceptor.getCookie(request,"");
			if (cookie != null) {
				cookie.setValue(null);
				response.addCookie(cookie);
			}

			if(str != null)
				response.sendRedirect("authenticate");

			return true;
		}
		else if(request.getRequestURL().toString().contains("register")){
			return true;
		}
		
		else if(request.getRequestURL().toString().contains("forget")){
			return true;
		}

		else if(request.getRequestURL().toString().contains("authenticate")){
			return true;
		}
		else{

			if(str == null){
				response.sendRedirect(request.getContextPath()+"/login");
				return false;
			}
			else{
				return true;
			}
		}

	}


}