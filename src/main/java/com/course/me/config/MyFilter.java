package com.course.me.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.course.me.util.JWTUtil;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

@Component
public class MyFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String authToken = ((HttpServletRequest) request).getHeader("Authorization");

		if(((HttpServletRequest) request).getRequestURI().contains("users/") || ((HttpServletRequest) request).getRequestURI().contains("swagger") ){
			chain.doFilter(request, response);
		}else {
			if (!JWTUtil.isTokenExpired(authToken)) {
				chain.doFilter(request, response);
			} else {
				HttpServletResponse httpResponse = (HttpServletResponse) response;
				httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				httpResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
				PrintWriter writer = httpResponse.getWriter();
				writer.print("You are unauthenticated!!");
				writer.flush();
				writer.close();
			}
		}
	}

}
