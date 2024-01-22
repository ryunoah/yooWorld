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
		
		//���͸� ��ġ�� ������Ʈ�� �Ǳ⶧�� �ٿ�ĳ���� �ѹ� �������~
		if(request instanceof HttpServletRequest) {
			HttpServletRequest req = (HttpServletRequest) request;
		
			uri = req.getRequestURI();
			
			if(req.getMethod().equalsIgnoreCase("POST")) {
				
				
				//�̰� �׳� ������
				//�̷��� ����ȭ�ؼ� ���ڵ� ó���Ҽ��� ����
				if(uri.indexOf("abc.do")!=-1) {
					req.setCharacterEncoding("euc-kr");
				} else {
					req.setCharacterEncoding(charset);
				}
			}
		
		}
		
		// Ŭ���̾�Ʈ - ���� �̴��� ���� Ŭ���̾�Ʈ - ���� - ���� �� �ȰŴϱ�
		// �̷��� ���� �۾������� ������ Ǫ�����ִ� �۾����� ����� 
		// Ŭ���̾�Ʈ�� �������� �ٳ�ü��ִ�
		// ����� ���Ϳ��� ���ͷ� �Ѿ���� ������
		// �ƹ�ư ��� �̷��� Ǫ������� �������� �ٳ���°�
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
