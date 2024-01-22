package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class EncodingFilter implements Filter{
	private String charset;
	
	
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String uri;
		
		//필터를 거치면 오브젝트가 되기때매 다운캐스팅 한번 해줘야함~
		if(request instanceof HttpServletRequest) {
			HttpServletRequest req = (HttpServletRequest) request;
		
			uri = req.getRequestURI();
			
			if(req.getMethod().equalsIgnoreCase("POST")) {
				
				
				//이건 그냥 예시임
				//이렇게 세분화해서 인코딩 처리할수도 있음
				if(uri.indexOf("abc.do")!=-1) {
					req.setCharacterEncoding("euc-kr");
				} else {
					req.setCharacterEncoding(charset);
				}
			}
		
		}
		
		// 클라이언트 - 서버 이던게 이젠 클라이언트 - 필터 - 서버 가 된거니까
		// 이렇게 필터 작업했으면 서버로 푸쉬해주는 작업까지 해줘야 
		// 클라이언트가 서버까지 다녀올수있다
		// 참고로 필터에서 필터로 넘어갈수도 있지만
		// 아무튼 계속 이렇게 푸쉬해줘야 서버까지 다녀오는거
		chain.doFilter(request, response);
		
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		charset = filterConfig.getInitParameter("charset");
		
		if(charset==null) {
			charset = "utf-8";
			
			
		}
	}

	
	
	
	
	
	
	
	
	
}
