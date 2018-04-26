package com.jone.ssm.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.util.StringUtils;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest requsest = (HttpServletRequest) arg0;
		HttpServletResponse resp = (HttpServletResponse) arg1;
		HttpSession session = requsest.getSession();
		String name = (String) session.getAttribute("name");
		String currentURL = requsest.getRequestURI();
		if(!currentURL.contains("login")){
			if (StringUtils.isEmpty(name)) {
				requsest.getRequestDispatcher("loginPage").forward(requsest, resp);
			} else {
				arg2.doFilter(arg0, arg1);
			}
		}else{
			arg2.doFilter(arg0, arg1);
		}
		

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
