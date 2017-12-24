/**
 * 
 */
package com.guess.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 李文兵
 *
 */
public class AuthenticationFilter implements Filter {

	/**
	 * 
	 */
	public AuthenticationFilter() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		
		String uri = req.getRequestURI();
		
		//验证是否登录过滤范围add文件添加的事物
		if(uri.contains("/guess/dynamicadd") || uri.contains("/guess/fileupload")){
			Object obj = req.getSession().getAttribute("USERALL");
			if(obj==null){
				 res.sendRedirect("dynamic?act=main");
			}
			else
			{
				chain.doFilter(request, response);
			}

		}
		else
		{
		   chain.doFilter(request, response);
		}

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

}
