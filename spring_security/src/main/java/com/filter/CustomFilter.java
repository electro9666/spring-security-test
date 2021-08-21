package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CustomFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("PrintURLFilter destroy() ---------------------------------");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("PrintURLFilter doFileter() 시작 ------------------------------------");

		HttpServletRequest req = (HttpServletRequest) request;
		System.out.println("요청 URL: " + req.getRequestURI() + " --------------------------------");
		chain.doFilter(request, response);

		System.out.println("PrintURLFilter doFileter() 끝 ------------------------------------");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("PrintURLFilter init() 시작 ------------------------------------");
		String FilterParam = config.getInitParameter("FilterParam");

		System.out.println("FilterParam: " + FilterParam + " -----------------");
		System.out.println("PrintURLFilter init() 끝--------------------------------------------------");
	}

}